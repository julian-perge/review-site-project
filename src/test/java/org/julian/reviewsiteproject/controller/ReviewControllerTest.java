package org.julian.reviewsiteproject.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.julian.reviewsiteproject.entities.Review;
import org.julian.reviewsiteproject.repository.ReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReviewsController.class)
public class ReviewControllerTest
{
	@Autowired
	private MockMvc mvc;

	@MockBean
	private ReviewRepository reviewRepo;

	@Mock
	private Review review;

	@Test
	public void shouldReturnModelAndViewOfAllReviewsAndIs2xxSuccessful() throws Exception
	{
		mvc.perform(get("/reviews"))
				.andExpect(view().name(is(equalTo("reviews"))))
				.andExpect(model().attribute("reviews", is(reviewRepo.findAll())))
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void shouldReturnModelAndViewOfSingleReviewAndIs2xxSuccessful() throws Exception
	{
		given(reviewRepo.findByTitle("title")).willReturn(review);

		mvc.perform(get("/reviews/title"))
				.andExpect(view().name(is(equalTo("review"))))
				.andExpect(model().attribute("review", is(review)))
				.andExpect(status().is2xxSuccessful());
	}
}