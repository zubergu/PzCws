package com.zubergu.weatherservice.rest.methods;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.zubergu.weatherservice.rest.entities.Subscriber;

@Path("subscriptions")
public class SubscriptionRestMethods {

    @POST
    @Path("add")
    @Consumes("application/json")
    public void saveSubscriberInDatabase(final Subscriber subscriber) {
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("$objectdb/localhost/SubscribersDB.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();

	em.persist(subscriber);
	em.getTransaction().commit();

	em.close();
	emf.close();
    }

}
