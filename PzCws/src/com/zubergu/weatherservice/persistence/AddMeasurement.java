package com.zubergu.weatherservice.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zubergu.weatherservice.rest.entities.Measurement;

public class AddMeasurement {
    public static void main(String[] args) {
	AddMeasurement add = new AddMeasurement();
	add.execute(new Measurement());
    }
    
    public void execute(final Measurement measurement) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CracowWeatherStation");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	
	em.persist(measurement);
	em.getTransaction().commit();
	
	em.close();
	emf.close();
    }
}
