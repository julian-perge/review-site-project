package org.julian.reviewsiteproject.repository;

import org.julian.reviewsiteproject.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends CrudRepository<Category, Long>
{
	public Category findByName(String name);
}
