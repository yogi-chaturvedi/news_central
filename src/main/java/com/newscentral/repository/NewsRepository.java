package com.newscentral.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.newscentral.domain.ECategory;
import com.newscentral.domain.ENews;

@Repository
public interface NewsRepository extends JpaRepository<ENews, Long>,CrudRepository<ENews, Long> {

	ENews findByTitle(String title);

	ENews findById(Long id);

	List<ENews> findAll();

	List<ENews> findByeCategory_id(Long eCategoryId);

	List<ENews> findByECategory(ECategory ecategory);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE ENews e SET e.title = :title,e.publishedOn=:publishedOn,e.imageUrl=:imageUrl,"
			+ "e.description=:description,e.source=:source WHERE e.id = :newsId")
	int update(@Param("newsId") Long newsId, @Param("title") String title, @Param("publishedOn") String publishedOn, 
			@Param("imageUrl") String imageUrl, @Param("description") String description, @Param("source") String source);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM ENews e WHERE e.id = :newsId")
	void delete(@Param("newsId") Long newsId);
}
