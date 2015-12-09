package com.zubergu.weatherservice.rest.methods;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zubergu.weatherservice.persistence.actions.subscriptions.AddSubscriber;
import com.zubergu.weatherservice.persistence.actions.subscriptions.RetrieveSubscriber;
import com.zubergu.weatherservice.persistence.entities.Subscriber;

@Path("subscriptions")
public class SubscriptionRestMethods {

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveSubscriberInDatabase(final Subscriber subscriber) {
	AddSubscriber as = new AddSubscriber();
	as.execute(subscriber);
    }

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Subscriber> retrieveAllSubscribers() {
	RetrieveSubscriber rs = new RetrieveSubscriber();
	return rs.retrieveAll();
    }
}
