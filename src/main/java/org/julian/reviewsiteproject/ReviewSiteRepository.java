package org.julian.reviewsiteproject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ReviewSiteRepository
{
	private Map<Long, Review> reviewRepository = new HashMap<Long, Review>();

	// id, title, imgUrl, category, content
	public ReviewSiteRepository()
	{
		Review terminatorReview = new Review(1L, "Terminator Review", "terminatorReviewImg", "Action", "This is a terminator review, and the movie came out 1984");
		Review theShiningReview = new Review(2L, "The Shining Review", "theShiningReviewImg", "Horror", "The Shining is scary");
		Review jurassicParkReview = new Review(3L, "Jurassic Park Review", "jurassicParkImg", "Adventure", "Dinos are adorable without teeth");
		
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
}
