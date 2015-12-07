package com.zubergu.weatherservice.persistence.actions.subscriptions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zubergu.weatherservice.persistence.entities.Subscriber;


public class AddSubscriber {
    public void execute(Subscriber subscriber) {
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("$objectdb/localhost/PzCws.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();

	em.persist(subscriber);
	em.getTransaction().commit();

	em.close();
	emf.close();
    }
}
