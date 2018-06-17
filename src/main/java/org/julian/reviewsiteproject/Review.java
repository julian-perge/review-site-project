package org.julian.reviewsiteproject;

import java.util.Collection;

public class Review {
	private Long id;
	private String title;
	private String imgUrl;
	private String category;
	private String content;
	private Collection<String> tags;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getCategory() {
		return category;
	}

	public String getContent() {
		return content;
	}
	
	public Collection<String> getTags()
	{
		return tags;
	}
	
	public void addTag(String tag)
	{
		tags.add(tag.replaceAll("\\s", ""));
	}

	public Review(Long id, String title, String imgUrl, String category, String content, Collection<String> tags) {
		super();
		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
		this.category = category;
		this.content = content;
		this.tags = tags;
	}
}
