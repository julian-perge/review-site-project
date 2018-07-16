package org.julian.reviewsiteproject.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {
  @Id @GeneratedValue private Long id;

  private String name;

  @ManyToMany (mappedBy = "tags")
  private Collection<Review> reviews;

  protected Tag() {}

  public Tag(String name) {
    this.name = name;
  }

  @JsonIgnore
  public Collection<Review> getReviews() {
    return reviews;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int hashCode() {
    return Tag.class.hashCode();
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
