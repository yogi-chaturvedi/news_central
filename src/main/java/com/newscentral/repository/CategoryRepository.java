package com.newscentral.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.newscentral.domain.ECategory;

@Repository
public interface CategoryRepository extends JpaRepository<ECategory, Long> {

	ECategory findByName(String name);

	ECategory findById(Long id);
	
	List<ECategory> findAll();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE ECategory e SET e.name = :name,e.logoUrl=:logoUrl,"
			+ "e.description=:description,e.updatedOn=:updatedOn,e.createdOn = :createdOn WHERE e.id = :categoryId")
	int update(@Param("categoryId") Long categoryId, @Param("name") String name, @Param("createdOn") String createdOn, 
			@Param("logoUrl") String logoUrl, @Param("description") String description, @Param("updatedOn") String updatedOn);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM ECategory e WHERE e.id = :categoryId")
	void delete(@Param("categoryId") Long categoryId);
}
