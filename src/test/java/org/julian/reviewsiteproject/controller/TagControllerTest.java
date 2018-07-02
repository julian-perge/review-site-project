package org.julian.reviewsiteproject.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.julian.reviewsiteproject.entities.Tag;
import org.julian.reviewsiteproject.repository.TagRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TagController.class)
public class TagControllerTest
{
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private TagRepository tagRepo;
	
	@Mock
	private Tag tag;
	
	@Test
	public void shouldReturnModelAndViewOfAllTagsAndIs2xxSuccessful() throws Exception
	{
		mvc.perform(get("/tags"))
								.andExpect(view().name(is(equalTo("tags"))))
								.andExpect(model().attribute("tags", is(tagRepo.findAll())))
								.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void shouldReturnModelAndViewOfSingleTagAndIs2xxSuccessful() throws Exception
	{
		given(tagRepo.findByName("name")).willReturn(tag);
		
		mvc.perform(get("/tags/name"))
									.andExpect(view().name(is(equalTo("tag"))))
									.andExpect(model().attribute("tag", is(tag)))
									.andExpect(status().is2xxSuccessful());
	}
}
