package com.zubergu.weatherservice.persistence.actions.measurements;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.zubergu.weatherservice.persistence.entities.Measurement;

public class RetrieveMeasurement {

    /**
     * 
     * @return latest measurement saved in database
     */
    public Measurement retrieveLatest() {
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("/home/zubergu/pzdatabase/PzCws.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();

	// Measurement latestMeasurement = em.find(Measurement.class, 17);
	Query q = em
		.createQuery("SELECT m from Measurement m order by m.measurementId DESC");
	q.setMaxResults(1);
	Measurement latestMeasurement = (Measurement) q.getResultList().get(0);
	em.close();
	emf.close();
	return latestMeasurement;
    }

    /**
     * 
     * @param date
     * @return measurements for wanted day
     */
    @SuppressWarnings("unchecked")
    public List<Measurement> retrieveForDay(Date date) {
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("/home/zubergu/pzdatabase/PzCws.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();
	Query q = em
		.createQuery("SELECT m from Measurement m where (m.date == :myDate)");
	List<Measurement> forDay = (List<Measurement>) (q.setParameter(
		"myDate", date, TemporalType.DATE).getResultList());

	em.close();
	emf.close();

	return forDay;
    }

    @SuppressWarnings("unchecked")
    public List<Measurement> retrieveForPeriod(Date startDate, Time startTime,
	    Date endDate, Time endTime) {
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("/home/zubergu/pzdatabase/PzCws.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();
	Query q = em
		.createQuery("SELECT m from Measurement m where (m.date >= :startDate AND m.date <= endDate AND m.time >= startTime AND m.time <= endTime)");
	q.setParameter("startDate", startDate, TemporalType.DATE);
	q.setParameter("startTime", startTime, TemporalType.DATE);
	q.setParameter("endDate", endDate, TemporalType.DATE);
	q.setParameter("endTime", endTime, TemporalType.DATE);
	List<Measurement> forPeriod = (List<Measurement>) (q.getResultList());

	em.close();
	emf.close();

	return forPeriod;
    }

}
