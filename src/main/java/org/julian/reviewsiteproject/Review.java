package org.julian.reviewsiteproject;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review
{
	@Id
	@GeneratedValue
	private Long id;

	private String title;
	private String imgUrl;

	@ManyToMany
	private Collection<Tag> tags;

	@ManyToOne
	private Category category;

	@Lob
	private String content;

	protected Review(){}

	public Review(String title, String imgUrl, String content, Category category , Tag ...tags)
	{
		this.title = title;
		this.imgUrl = imgUrl;
		this.content = content;
		this.category = category;
		this.tags = Arrays.asList(tags);
	}
	
	@Override
	public String toString()
	{
		return title + " - " + category;
	}

	public Long getId()
	{
		return id;
	}

	public String getTitle()
	{
		return title;
	}

	public String getImgUrl()
	{
		return imgUrl;
	}

	public Category getCategory()
	{
		return category;
	}

	public String getContent()
	{
		return content;
	}

	public Collection<Tag> getTags()
	{
		return tags;
	}
}
