package com.newscentral.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "comment")

@Entity
public class EComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column
	String value;

	@Column(name = "published_on")
	String publishedOn;
	
	@Column(name = "updated_on")
	String updatedOn;

	@Column
	long likes;

	@Column
	long dislikes;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL,CascadeType.PERSIST})
	@JoinColumn(name = "news_id")
	ENews eNews;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPublishedOn() {
		return publishedOn;
	}

	public void setPublishedOn(String publishedOn) {
		this.publishedOn = publishedOn;
	}

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	public long getDislikes() {
		return dislikes;
	}

	public void setDislikes(long dislikes) {
		this.dislikes = dislikes;
	}

	public void seteNews(ENews eNews) {
		this.eNews = eNews;
	}

	Long newsId;

	public Long getNewsId() {
		return eNews.getId();
	}

	public void setNewsId(Long newsId) {
		this.newsId = eNews.getId();
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	
}
