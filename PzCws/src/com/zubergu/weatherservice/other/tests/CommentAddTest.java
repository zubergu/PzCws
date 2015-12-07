package com.zubergu.weatherservice.other.tests;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.zubergu.weatherservice.persistence.actions.comments.AddComment;
import com.zubergu.weatherservice.persistence.entities.Comment;

@Path("testing2")
public class CommentAddTest {
    
    @GET
    @Path("commentAdd")
    public void addCommentTest() {
	AddComment action = new AddComment();
	Comment comment = new Comment();
	
	comment.setComment("Fajnie, fajnie");
	comment.setUserName("zubergu");
	
	action.execute(comment);
	
    }
}
