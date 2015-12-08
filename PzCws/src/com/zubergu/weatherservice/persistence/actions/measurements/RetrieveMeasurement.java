package com.zubergu.weatherservice.persistence.actions.measurements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.zubergu.weatherservice.persistence.entities.Measurement;

public class RetrieveMeasurement {
    
    public Measurement retrieveLatest() {
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("$objectdb/localhost/PzCws.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();

	//Measurement latestMeasurement = em.find(Measurement.class, 17);
	Query q = em.createQuery("SELECT m from Measurement m order by m.measurementId DESC");
	q.setMaxResults(1);
	Measurement latestMeasurement = (Measurement) q.getResultList().get(0);
	em.close();
	emf.close();
	return latestMeasurement;
    }
    
    public List<Measurement> retrieveForDay(Date date) {
	List<Measurement> forDay = new ArrayList<Measurement>();
	
	return forDay;
    }
    
    public List<Measurement> retrieveForPeriod(Date startDate, Date endDate) {
	List<Measurement> forPeriod = new ArrayList<Measurement>();
	
	return forPeriod;
    }

}
