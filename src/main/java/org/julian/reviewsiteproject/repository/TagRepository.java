package org.julian.reviewsiteproject.repository;

import org.julian.reviewsiteproject.entities.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>
{
	public Tag findByName(String name);
}
