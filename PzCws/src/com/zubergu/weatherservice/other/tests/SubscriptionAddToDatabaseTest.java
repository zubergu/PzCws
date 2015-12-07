package com.zubergu.weatherservice.other.tests;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.zubergu.weatherservice.persistence.actions.subscriptions.AddSubscriber;
import com.zubergu.weatherservice.persistence.entities.Subscriber;

@Path("testing")
public class SubscriptionAddToDatabaseTest {
    
    @GET
    @Path("subscriberAdd")
    public void addSubscription() {
	AddSubscriber asAction = new AddSubscriber();
	Subscriber sub = new Subscriber();
	sub.setEmail("dummy@some.com");
	sub.setUserFirstName("Dummy");
	sub.setUserLastName("LastDummy");
	asAction.execute(sub);
    }
}
