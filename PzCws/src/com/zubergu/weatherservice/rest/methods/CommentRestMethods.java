package com.zubergu.weatherservice.rest.methods;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zubergu.weatherservice.persistence.actions.comments.AddComment;
import com.zubergu.weatherservice.persistence.actions.comments.RetrieveComments;
import com.zubergu.weatherservice.persistence.entities.Comment;

@Path("comments")
public class CommentRestMethods {

    @Path("add")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void addComment(Comment comment) {
	new AddComment().execute(comment);
    }

    @Path("last/{number}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getLastComments(
	    @PathParam("number") Integer numberOfLastComments) {
	RetrieveComments rc = new RetrieveComments();
	return rc.retrieveLastComments(numberOfLastComments);
    }

}
