package com.zubergu.weatherservice.persistence.actions.subscriptions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.zubergu.weatherservice.persistence.entities.Subscriber;

public class RetrieveSubscriber {

    @SuppressWarnings("unchecked")
    public List<Subscriber> retrieveAll() {
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("/home/zubergu/pzdatabase/PzCws.odb");
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();

	Query q = em.createQuery("SELECT s from Subscriber s");
	List<Subscriber> subscribersList = (List<Subscriber>) q.getResultList();
	em.close();
	emf.close();
	return subscribersList;
    }
}
