package com.newscentral.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newscentral.domain.EComment;
import com.newscentral.model.Comment;
import com.newscentral.services.CommentService;

@RestController("commentControllerV1")
@RequestMapping("v1")
public class CommentController {

	@Inject
	CommentService commentService;
	
	//post comment
	@RequestMapping(value = "/news/{newsId}/comment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	String postComment(@PathVariable Long newsId, @RequestBody Comment comment) {
		return commentService.postComment(newsId, comment);
	}

	//get comments
	@RequestMapping(value = "/news/{newsId}/comment", method = RequestMethod.GET)
	List<EComment> getComment(@PathVariable Long newsId) {
		return commentService.getComments(newsId);
	}
	
	//edit comment
	@RequestMapping(value = "/news/{commmentId}/comment", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	String updateComment(@PathVariable Long commmentId, @RequestBody Comment comment) {
		return commentService.updateComment(commmentId, comment);
	}
	
	//delete comment
	@RequestMapping(value = "/comment/{commentId}", method = RequestMethod.DELETE)
	String deleteComment(@PathVariable Long commentId) {
		return commentService.deleteComment(commentId);
	}
}
