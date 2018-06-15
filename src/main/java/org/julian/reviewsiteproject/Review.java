package org.julian.reviewsiteproject;

public class Review
{
	private long movieId;
	private String title;
	private String imgUrl;
	private String category;
	private String content;

	public Review(long movieId, String title, String imgUrl, String category, String content)
	{
		super();
		this.movieId = movieId;
		this.title = title;
		this.imgUrl = imgUrl;
		this.category = category;
		this.content = content;
	}
	
	public long getMovieId()
	{
		return movieId;
	}
	public String getTitle()
	{
		return title;
	}
	public String getImgUrl()
	{
		return imgUrl;
	}
	public String getCategory()
	{
		return category;
	}
	public String getContent()
	{
		return content;
	}
	
	
}
