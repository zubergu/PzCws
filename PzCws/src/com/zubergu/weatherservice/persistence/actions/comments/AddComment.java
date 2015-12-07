package com.zubergu.weatherservice.persistence.actions.comments;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zubergu.weatherservice.persistence.entities.Comment;

public class AddComment {
    
    public void execute(final Comment comment) {	
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("$objectdb/localhost/WSC.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();

	em.persist(comment);
	em.getTransaction().commit();

	em.close();
	emf.close();
    }
}

