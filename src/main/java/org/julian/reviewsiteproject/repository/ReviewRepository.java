package org.julian.reviewsiteproject.repository;

import org.julian.reviewsiteproject.entities.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>
{

	public Review findByTitle(String title);
	
}