package com.newscentral.services;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.newscentral.domain.ECategory;
import com.newscentral.model.Category;

@ComponentScan
public interface CategoryService {

	ECategory getById(Long id);

	ECategory getByName(String name);

	ECategory saveCategory(Category category);

	List<ECategory> listCategory();

	String updateCategory(Long categoryId, Category category);

	String deleteCategory(Long categoryId);

}
