package org.julian.reviewsiteproject.repository;

import org.julian.reviewsiteproject.entities.ReviewComment;
import org.springframework.data.repository.CrudRepository;

public interface ReviewCommentRepository extends CrudRepository<ReviewComment, Long> {

}
