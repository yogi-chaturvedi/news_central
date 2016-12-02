package com.newscentral.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class News {
	
	@JsonProperty
	Long id;
	@JsonProperty
	String title;
	@JsonProperty
	String publishedOn;
	@JsonProperty
	String imageUrl;
	@JsonProperty
	String description;
	@JsonProperty
	String source;
	@JsonProperty
	long likes;
	@JsonProperty
	long dislikes;
	@JsonProperty
	long categoryId;
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getPublishedOn() {
		return publishedOn;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getDescription() {
		return description;
	}
	public String getSource() {
		return source;
	}
	public long getLikes() {
		return likes;
	}
	public long getDislikes() {
		return dislikes;
	}
	public long getCategoryId() {
		return categoryId;
	}
}
