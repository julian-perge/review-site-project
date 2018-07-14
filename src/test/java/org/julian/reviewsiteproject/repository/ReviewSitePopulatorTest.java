package org.julian.reviewsiteproject.repository;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import org.julian.reviewsiteproject.entities.Category;
import org.julian.reviewsiteproject.entities.Review;
import org.julian.reviewsiteproject.entities.ReviewComment;
import org.julian.reviewsiteproject.entities.Tag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ReviewSitePopulatorTest {
  @Autowired private ReviewRepository reviewRepo;
  @Autowired private CategoryRepository catRepo;
  @Autowired private TagRepository tagRepo;

  @Mock private Review review;
  @Mock private ReviewComment reviewComment;

  @Before
  public void before() {
    Category catTest = catRepo.save(new Category("Test Category"));
    Tag tagTest = tagRepo.save(new Tag("Test Tag"));
    Review revTest =
        reviewRepo.save(
            new Review("TestTitle", "terminatorReviewImg", "ayyy lmao", catTest, tagTest));
  }

  @Test
  public void populatorShouldSaveandLoadReview() throws Exception {
    Review testReview = reviewRepo.findOne(1L);
    assertThat(testReview.getTitle(), is(equalTo("TestTitle")));
  }

  @Test
  public void populatorShouldGenerateReviewId() throws Exception {
    assertTrue(reviewRepo.exists(1l));
  }

  @Test
  public void populatorShouldSaveTagToReview() throws Exception {
    Review testReview = reviewRepo.findOne(1L);
    Tag underTestTag = tagRepo.findOne(1L);
    assertTrue(testReview.getTags().contains(underTestTag));
  }

  @Test
  public void populatorShouldSaveCommentToReview() throws Exception {
    given(reviewRepo.findByTitle("ReviewTitle").getReviewComments().iterator().next())
        .willReturn(reviewComment);
    given(reviewRepo.findByTitle("ReviewTitle")).willReturn(review);

    reviewRepo.findByTitle("ReviewTitle").addReviewComment(reviewComment);

    assertThat(review.getReviewComments().size(), greaterThan(0));
  }

  @Test
  public void populatorShouldFindReviewsForCategory() throws Exception {
    Category testCat = catRepo.findOne(1L);
    Tag underTestTag = tagRepo.findOne(1L);
    Review testReview = reviewRepo.findOne(1L);
    Review testReview2 =
        reviewRepo.save(
            new Review("TestTitle2", "testImgUrl2", "ayyy lmao2", testCat, underTestTag));
    assertThat(testCat.getReviews().size(), is(equalTo(2)));
  }
}
