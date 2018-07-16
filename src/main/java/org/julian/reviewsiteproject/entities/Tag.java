package org.julian.reviewsiteproject.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {
  @Id @GeneratedValue private Long id;

  private String name;

  @ManyToMany(targetEntity=org.julian.reviewsiteproject.entities.Review.class, mappedBy="tags")
  private Collection<Review> reviews;

  protected Tag() {}

  public Tag(final String name) {
    this.name = name;
  }

  public Tag(String name, Review review) {
    this.name = name;
  }

  @JsonIgnore
  public Collection<Review> getReviews() {
    return reviews;
  }
  
  public void addReview(Review review) {
	this.reviews.add(review);
	if (!review.getTags().contains(this) ) {
		review.getTags().add(this);
	}
  }

  @Override
  public String toString() {
    return name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Tag other = (Tag) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    if (name == null) {
      if (other.name != null) return false;
    } else if (!name.equals(other.name)) return false;
    if (reviews == null) {
      if (other.reviews != null) return false;
    } else if (!reviews.equals(other.reviews)) return false;
    return true;
  }

}
