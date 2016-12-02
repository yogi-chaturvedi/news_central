package com.newscentral.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.newscentral.domain.ECategory;
import com.newscentral.domain.EComment;
import com.newscentral.domain.ENews;
import com.newscentral.model.News;
import com.newscentral.repository.CategoryRepository;
import com.newscentral.repository.NewsRepository;

@Named
public class NewsServiceImpl implements NewsService {
	@Inject
	NewsRepository newsRepository;
	@Inject
	CategoryRepository categoryRepository;
	@Inject 
	CommentService commentService;

	@Override
	public ENews getNews(Long id) {

		return newsRepository.findById(id);
	}

	@Override
	public String saveNews(News news) {
		ENews eNews = new ENews();
		eNews.setDescription(news.getDescription());
		ECategory eCategory = new ECategory();
		Long categoryId = news.getCategoryId();
		eCategory = categoryRepository.findById(categoryId);
		eNews.seteCategory(eCategory);
		eNews.setDislikes(news.getDislikes());
		eNews.setImageUrl(news.getImageUrl());
		eNews.setLikes(news.getLikes());
		eNews.setPublishedOn(news.getPublishedOn());
		eNews.setSource(news.getSource());
		eNews.setTitle(news.getTitle());
		newsRepository.save(eNews);
		return "Data saved successfully";
	}

	@Override
	public List<ENews> listNews() {
		return newsRepository.findAll();
	}

	@Override
	public List<ENews> listNewsSpecific(Long eCategoryId) {
		ECategory ecategory = new ECategory();
		ecategory.setId(eCategoryId);
		return newsRepository.findByeCategory_id(eCategoryId);
	}

	@Override
	public String updateNews(Long newsId, News news) {
		String title = "fssfsf", publishedOn,  imageUrl, description, source;
		Long categoryId=(long) 0;
		ENews eNews = newsRepository.findById(newsId);
		
		if(news.getTitle()!=null)
			title=news.getTitle();
		else
			title=eNews.getTitle();
		
		if(news.getPublishedOn()!=null)
			publishedOn=news.getPublishedOn();
		else
			publishedOn=eNews.getPublishedOn();
		
		if(news.getImageUrl()!=null)
			imageUrl=news.getImageUrl();
		else
			imageUrl=eNews.getImageUrl();
		
		if(news.getDescription()!=null)
			description=news.getDescription();
		else
			description=eNews.getDescription();
		
		if(news.getSource()!=null)
			source=news.getSource();
		else
			source=eNews.getSource();
		categoryId = news.getCategoryId();
		if(categoryId!=0)
			categoryId=news.getCategoryId();
		else
			categoryId=eNews.getCategoryId();
		
		newsRepository.update(newsId, title, publishedOn, imageUrl, description, source);
		return "news : " + newsId + "updated successfully";
	}
	
	
	@Override
	public String deleteNews(Long newsId) {
		List<EComment> comments = commentService.getComments(newsId);
		for(EComment comment : comments){
			commentService.deleteComment(comment.getId());
		}
		newsRepository.delete(newsId);
		return "news : " + newsId + "deleted successfully";
	}

}
