package org.julian.reviewsiteproject.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Embeddable
public class ReviewCommentEmbed {

  @Column(name = "REVCOM_TITLE")
  private String title;

  @Column(name = "REVCOM_DESCRIPTION")
  @Lob
  private String description;

  protected ReviewCommentEmbed() {}

  public ReviewCommentEmbed(String title, String description) {
    this.title = title;
    this.description = description;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ReviewCommentEmbed other = (ReviewCommentEmbed) obj;
    if (description == null) {
      if (other.description != null) return false;
    } else if (!description.equals(other.description)) return false;
    if (title == null) {
      if (other.title != null) return false;
    } else if (!title.equals(other.title)) return false;
    return true;
  }

  @Override
  public String toString() {
    return title;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }
}
