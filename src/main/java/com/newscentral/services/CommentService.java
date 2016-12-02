package com.newscentral.services;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.newscentral.domain.EComment;
import com.newscentral.model.Comment;

@ComponentScan
public interface CommentService {

	String postComment(Long newsId,Comment comment);
	
	List<EComment> getComments(Long newsId);
	
	String deleteComment(Long commentId);

	String updateComment(Long newsId, Comment comment);
}
