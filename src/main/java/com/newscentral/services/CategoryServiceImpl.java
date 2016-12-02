package com.newscentral.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.newscentral.domain.ECategory;
import com.newscentral.domain.ENews;
import com.newscentral.model.Category;
import com.newscentral.repository.CategoryRepository;

@Named
public class CategoryServiceImpl implements CategoryService {
	@Inject
	CategoryRepository categoryRepository;
	@Inject
	NewsService newsService;
	@Override
	public ECategory getById(Long id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public ECategory getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ECategory saveCategory(Category category) {
		ECategory eCategory = new ECategory();
		eCategory.setName(category.getName());
		eCategory.setDescription(category.getDescription());
		eCategory.setLogoUrl(category.getLogoUrl());
		eCategory.setUpdatedOn(category.getUpdatedOn());
		eCategory.setCreatedOn(category.getCreatedOn());
		return categoryRepository.save(eCategory);
	}

	@Override
	public List<ECategory> listCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public String updateCategory(Long categoryId, Category category) {
		String name , createdOn,  logoUrl, description, updatedOn;
		ECategory eCategory = categoryRepository.findById(categoryId);
		
		if(category.getName()!=null)
			name=category.getName();
		else
			name=eCategory.getName();
		
		if(category.getCreatedOn()!=null)
			createdOn=category.getCreatedOn();
		else
			createdOn=eCategory.getCreatedOn();
		
		if(category.getLogoUrl()!=null)
			logoUrl=category.getLogoUrl();
		else
			logoUrl=eCategory.getLogoUrl();
		
		if(category.getDescription()!=null)
			description=category.getDescription();
		else
			description=eCategory.getDescription();
		
		if(category.getUpdatedOn()!=null)
			updatedOn=category.getUpdatedOn();
		else
			updatedOn=eCategory.getUpdatedOn();
		
		categoryRepository.update(categoryId, name, createdOn, logoUrl, description, updatedOn);
		return "news : " + categoryId + "updated successfully";
	}

	@Override
	public String deleteCategory(Long categoryId) {
		List<ENews> newsList = newsService.listNewsSpecific(categoryId);
		for(ENews news : newsList){
			newsService.deleteNews(news.getId());
		}
		categoryRepository.delete(categoryId);
		return "news : " + categoryId + "deleted successfully";
	}
}
