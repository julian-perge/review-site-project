package org.julian.reviewsiteproject.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.julian.reviewsiteproject.entities.Category;
import org.julian.reviewsiteproject.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest
{	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CategoryRepository catRepo;
	
	@Mock
	private Category category;
	
	@Test
	public void shouldReturnModelAndViewOfAllCategoriesAndIs2xxSuccessful() throws Exception
	{
		mvc.perform(get("/categories"))
										.andExpect(view().name(is(equalTo("categories"))))
										.andExpect(model().attribute("categories", is(catRepo.findAll())))
										.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void shouldReturnModelAndViewOfSingleCategoryAndIs2xxSuccessful() throws Exception
	{
		given(catRepo.findByName("name")).willReturn(category);
		
		mvc.perform(get("/category/name"))
										.andExpect(view().name(is(equalTo("category"))))
										.andExpect(model().attribute("category", is(category)))
										.andExpect(status().is2xxSuccessful());
	}
}
