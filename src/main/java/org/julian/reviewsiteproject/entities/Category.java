package org.julian.reviewsiteproject.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
  @Id @GeneratedValue private Long id;

  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "category")
  private Collection<Review> reviews;

  protected Category() {}

  public Category(String name) {
    this.name = name;
  }

  public Collection<Review> getReviews() {
    return reviews;
  }

  @Override
  public String toString() {
    return name;
  }

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }
}
