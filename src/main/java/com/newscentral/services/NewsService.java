package com.newscentral.services;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.newscentral.domain.ENews;
import com.newscentral.model.News;

@ComponentScan
public interface NewsService {

	
	ENews getNews(Long id);

	String saveNews(News News);

	List<ENews> listNews();
	
	List<ENews> listNewsSpecific(Long eCategoryId);

	String updateNews(Long newsId, News news);

	String deleteNews(Long newsId);
	
}
