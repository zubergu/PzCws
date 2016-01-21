package com.zubergu.weatherservice.persistence.actions.measurements;

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
    public List<Measurement> retrieveForPeriod(Date startDate, Date endDate) {
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("/home/zubergu/pzdatabase/PzCws.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();
	Query q = em
		.createQuery("SELECT m from Measurement m where (m.date >= :startDate AND m.date <= :endDate)");
	q.setParameter("startDate", startDate, TemporalType.DATE);

	q.setParameter("endDate", endDate, TemporalType.DATE);

	List<Measurement> forPeriod = (List<Measurement>) (q.getResultList());

	em.close();
	emf.close();

	return forPeriod;
    }

    public Float averageTemperatureForDay(Date date) {
	List<Measurement> measurements = retrieveForDay(date);
	float sum = 0;
	for (Measurement m : measurements) {
	    sum += m.getTemperature();
	}

	return sum / measurements.size();
    }
    
    public Float minTemperatureForDay(Date date) {
	List<Measurement> measurements = retrieveForDay(date);
	float min = Float.POSITIVE_INFINITY;
	for (Measurement m : measurements) {
	    if (m.getTemperature() < min) {
		min = m.getTemperature();
	    }
	}

	return min;
    }
    
    
    public Float maxTemperatureForDay(Date date) {
	List<Measurement> measurements = retrieveForDay(date);
	float max = Float.NEGATIVE_INFINITY;
	for (Measurement m : measurements) {
	    if (m.getTemperature() > max) {
		max = m.getTemperature();
	    }
	}

	return max;
    }
    

    public Float averageTemperatureForPeriod(Date startDate, Date endDate) {
	List<Measurement> measurements = this.retrieveForPeriod(startDate,
		endDate);
	float sum = 0;
	for (Measurement m : measurements) {
	    sum += m.getTemperature();
	}

	return sum / measurements.size();
    }

    public Float minTemperatureForPeriod(Date startDate, Date endDate) {
	List<Measurement> measurements = this.retrieveForPeriod(startDate,
		endDate);
	float min = Float.POSITIVE_INFINITY;
	for (Measurement m : measurements) {
	    if (m.getTemperature() < min) {
		min = m.getTemperature();
	    }
	}

	return min;
    }

    public Float maxTemperatureForPeriod(Date startDate, Date endDate) {
	List<Measurement> measurements = this.retrieveForPeriod(startDate,
		endDate);
	float max = Float.NEGATIVE_INFINITY;
	for (Measurement m : measurements) {
	    if (m.getTemperature() > max) {
		max = m.getTemperature();
	    }
	}

	return max;
    }

}
