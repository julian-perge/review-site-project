package org.julian.reviewsiteproject;

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
		Review terminatorReview = new Review(1L, "Terminator", "terminatorReviewImg", "Action", "This is a terminator review, and the movie came out 1984");
		terminatorReview.addTag("cyborg");
		terminatorReview.addTag("time travel");
		terminatorReview.addTag("future war");
		// making sure tag list works
		terminatorReview.addTag("testing");
		
		Review theShiningReview = new Review(2L, "The Shining", "theShiningReviewImg", "Horror", "The Shining is scary");
		theShiningReview.addTag("hotel");
		theShiningReview.addTag("identical twins");
		theShiningReview.addTag("isolation");
		
		theShiningReview.addTag("testing");
		
		Review jurassicParkReview = new Review(3L, "Jurassic Park", "jurassicParkImg", "Adventure", "Dinos are adorable without teeth");
		jurassicParkReview.addTag("dinosuar");
		jurassicParkReview.addTag("theme park");
		jurassicParkReview.addTag("island");
		
		jurassicParkReview.addTag("testing");
		
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
		reviewRepository.put(review.getMovieId(), review);
	}

	public Collection<Review> getReviews()
	{
		return reviewRepository.values();
	}

	public Review findById(Long movieId)
	{
		return reviewRepository.get(movieId);
	}
	
	public Collection<String> getAllTags()
	{
		Collection<String> reviewTags = new HashSet<String>();
		
		for (Review review : getReviews()) {
			reviewTags.addAll(review.getTags());
		}
		
		return reviewTags;
	}
	
	public Collection<Review> findByTag(String tag)
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
