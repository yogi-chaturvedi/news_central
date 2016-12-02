package com.newscentral.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.newscentral.domain.EComment;
import com.newscentral.domain.ENews;
import com.newscentral.model.Comment;
import com.newscentral.repository.CommentRepository;

@Named
public class CommentServiceImpl implements CommentService {
	@Inject
	CommentRepository commentRepository;

	@Override
	public String postComment(Long newsId, Comment comment) {
		EComment eComment = new EComment();
		eComment.setValue(comment.getValue());
		eComment.setPublishedOn(comment.getPublishedOn());
		ENews eNews = new ENews();
		eNews.setId(newsId);
	    eComment.seteNews(eNews);
		commentRepository.save(eComment);
		return "commented successfully on news : " + newsId;
	}

	@Override
	public List<EComment> getComments(Long newsId) {
		
		ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
		ArrayList<EComment> eComments = new ArrayList<EComment>();
		List<Object[]> commentList = commentRepository.findAll(newsId);
		for (Object[] obj : commentList) {
			HashMap<String, Object> hashMap = new HashMap<>();
			hashMap.put("id", obj[0]);
			hashMap.put("value", obj[1]);
			Long id = (Long) obj[0];
			String value = (String) obj[1];
			EComment comment = new EComment();
			comment.setId(id);
			comment.setValue(value);
			eComments.add(comment);
			arrayList.add(hashMap);
		}

		return eComments;
	}

	@Override
	public String deleteComment(Long commentId) {
		commentRepository.delete(commentId);
		return "Comment : "+commentId+ " deleted successfully";
	}

	@Override
	public String updateComment(Long commentId, Comment comment) {
		String value = "fssfsf", publishedOn,  updatedOn;
		EComment eComment = commentRepository.findById(commentId);
		
		if(eComment.getValue()!=null)
			value=comment.getValue();
		else
			value=eComment.getValue();
		
		if(comment.getPublishedOn()!=null)
			publishedOn=comment.getPublishedOn();
		else
			publishedOn=eComment.getPublishedOn();
		
		if(comment.getUpdatedOn()!=null)
			updatedOn=comment.getUpdatedOn();
		else
			updatedOn=eComment.getUpdatedOn();
				
		commentRepository.update(commentId, value, publishedOn, updatedOn);
		return "comment : " + commentId + "updated successfully";
	}

}
