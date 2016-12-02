package com.newscentral.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newscentral.domain.ECategory;
import com.newscentral.domain.ENews;
import com.newscentral.model.Category;
import com.newscentral.services.CategoryService;
import com.newscentral.services.NewsService;

@RestController("categoryControllerV1")
@RequestMapping("v1/category")
public class CategoryController {

	@Inject
	CategoryService categoryService;
	@Inject
	NewsService newsService;

	// get category
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ECategory getProduct(@PathVariable Long id) {
		return categoryService.getById(id);
	}

	// save category
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	ECategory saveProduct(@RequestBody Category category) {
		return categoryService.saveCategory(category);
	}

	// update category
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	String updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
		return categoryService.updateCategory(categoryId, category);
	}

	// get category list
	@RequestMapping(value = "", method = RequestMethod.GET)
	List<ECategory> getAll() {
		return categoryService.listCategory();
	}

	// get news list of particular category
	@RequestMapping(value = "/{id}/news", method = RequestMethod.GET)
	List<ENews> getNewsSpecific(@PathVariable Long id) {
		return newsService.listNewsSpecific(id);
	}

	// delete category
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.DELETE)
	String deleteNews(@PathVariable Long categoryId) {
		return categoryService.deleteCategory(categoryId);
	}

}
