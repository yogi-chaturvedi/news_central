package com.newscentral.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newscentral.domain.ENews;
import com.newscentral.model.News;
import com.newscentral.services.NewsService;

@RestController("newsControllerV1")
@RequestMapping("v1/news")
public class NewsController {

	@Inject
	NewsService newsService;

	//get news by id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ENews getProduct(@PathVariable Long id) {
		return newsService.getNews(id);

	}

	//save news
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	String saveProduct(@RequestBody News news) {
		return newsService.saveNews(news);

	}
	
	//get news list
	@RequestMapping(value = "", method = RequestMethod.GET)
	List<ENews> getAll() {
		return newsService.listNews();

	}
	
	//update news
	@RequestMapping(value = "/{newsId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	String updateNews(@PathVariable Long newsId, @RequestBody News news) {
		return newsService.updateNews(newsId, news);
	}
	
	//delete news
	@RequestMapping(value = "/{newsId}", method = RequestMethod.DELETE)
	String deleteNews(@PathVariable Long newsId) {
		return newsService.deleteNews(newsId);
	}
}
