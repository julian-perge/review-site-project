package org.julian.reviewsiteproject;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ReviewSiteRepository
{
	private Map<Long, Review> reviewRepository = new HashMap<Long, Review>();
	
	// id, title, imgUrl, category, content, collection of tags
	public ReviewSiteRepository()
	{
		Review terminatorReview = new Review(1L, "Terminator", 
				"terminatorReviewImg", "Action", "This is a terminator review, and the movie came out 1984", 
				Arrays.asList("cyborg", "time travel", "isolation", "testing"));
				
		Review theShiningReview = new Review(2L, "The Shining", "theShiningReviewImg", "Horror", "The Shining is scary", 
				Arrays.asList("hotel", "identical twins", "isolation", "testing"));
		
		Review jurassicParkReview = new Review(3L, "Jurassic Park", "jurassicParkImg", "Adventure", "Dinos are adorable without teeth", 
				Arrays.asList("dinosaur", "theme park", "island", "testing"));		
		
		this.addReview(terminatorReview);
		this.addReview(theShiningReview);
		this.addReview(jurassicParkReview);
	}

	public int getSizeOfRepository()
	{
		// return integer of repo size
		return reviewRepository.size();
	}
	
	public void addReview(Review review)
	{
		reviewRepository.put(review.getId(), review);
	}

	public Collection<Review> getReviews()
	{
		return reviewRepository.values();
	}

	public Review findById(Long i)
	{
		return reviewRepository.get(i);
	}
	
	public Collection<String> getAllTags()
	{
		Collection<String> reviewTags = new HashSet<String>();
		
		for (Review review : getReviews()) {
			reviewTags.addAll(review.getTags());
		}
		return reviewTags;
	}
	
	public Collection<Review> findReviewsByTag(String tag)
	{
		Collection<Review> reviewsThatContainTag = new HashSet<Review>();
		
		for (Review review : getReviews()) {
			if(review.getTags().contains(tag))
			{
				reviewsThatContainTag.add(review);
			}
		}
		return reviewsThatContainTag;
	}
}
