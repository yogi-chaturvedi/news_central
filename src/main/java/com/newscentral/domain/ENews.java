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

@Table(name = "news")
@Entity
public class ENews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column
	String title;

	@Column(name = "published_on")
	String publishedOn;

	@Column(name = "image_url")
	String imageUrl;

	@Column
	String description;

	@Column
	String source;

	@Column
	long likes;

	@Column
	long dislikes;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	ECategory eCategory;

	long categoryId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishedOn() {
		return publishedOn;
	}

	public void setPublishedOn(String publishedOn) {
		this.publishedOn = publishedOn;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
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

	public void seteCategory(ECategory eCategory) {
		this.eCategory = eCategory;
	}

	public long getCategoryId() {
		return eCategory.getId();
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = eCategory.getId();
	}
}
