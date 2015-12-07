package com.zubergu.weatherservice.persistence.actions.measurements;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zubergu.weatherservice.persistence.entities.Measurement;

public class AddMeasurement {
    
    public void execute(final Measurement measurement) {	
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("$objectdb/localhost/WSC.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();

	em.persist(measurement);
	em.getTransaction().commit();

	em.close();
	emf.close();
    }
}
