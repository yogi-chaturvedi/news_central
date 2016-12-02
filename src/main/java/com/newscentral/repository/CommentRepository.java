package com.newscentral.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.newscentral.domain.EComment;
import java.lang.Long;

@Repository
public interface CommentRepository extends CrudRepository<EComment, Long> {

	EComment findById(Long id);

	@Query(value = "SELECT e.id,e.value FROM EComment e WHERE news_id=?1")
	List<Object[]> findAll(Long eNewsId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE EComment e SET e.value = :value,e.publishedOn=:publishedOn,e.updatedOn=:updatedOn "
			+"WHERE e.id = :commentId")
	int update(@Param("commentId") Long commentId, @Param("value") String value, @Param("publishedOn") String publishedOn, 
			@Param("updatedOn") String updatedOn);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM EComment e WHERE e.id = :commentId")
	void delete(@Param("commentId") Long commentId);

}
