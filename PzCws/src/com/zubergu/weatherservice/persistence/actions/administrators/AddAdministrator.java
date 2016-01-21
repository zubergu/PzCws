package com.zubergu.weatherservice.persistence.actions.administrators;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zubergu.weatherservice.persistence.entities.Administrator;

public class AddAdministrator {
    public void execute(final Administrator admin) {	
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("/home/zubergu/pzdatabase/PzCws.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();

	em.persist(admin);
	em.getTransaction().commit();

	em.close();
	emf.close();
    }
}
