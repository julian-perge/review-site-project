package org.julian.reviewsiteproject;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReviewSiteController.class)
public class ReviewSiteControllerTest
{
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ReviewSiteRepository repo;
	
	@Mock
	private Review review;
	
	@Test
	public void shouldReturnModelAndViewOfReviewsAndIs2xxSuccessful() throws Exception
	{
		mvc.perform(get("/reviews"))
									.andExpect(view().name(is(equalTo("reviews"))))
									.andExpect(status().is2xxSuccessful())
									.andExpect(model().attribute("reviews", is(repo.getReviews())));
	}
	
	@Test
	public void shouldReturnModelAndViewOfSingleReviewAndIs2xxSuccessful() throws Exception
	{
		given(repo.findById(42L)).willReturn(review);
		
		mvc.perform(get("/reviews/42"))
										.andExpect(view().name(is(equalTo("review"))))
										.andExpect(status().is2xxSuccessful())
										.andExpect(model().attribute("review", is(review)));
	}
	
	@Test
	public void shouldReturnModelAndViewOfSearchedTagAndIs2xxSuccessful() throws Exception
	{
		mvc.perform(get("/reviews/tags"))
		.andExpect(view().name(is(equalTo("tags"))))
		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attribute("tags", is(repo.getAllTags())));
	}
}
