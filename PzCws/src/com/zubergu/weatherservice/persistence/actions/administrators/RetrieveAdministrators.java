package com.zubergu.weatherservice.persistence.actions.administrators;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.zubergu.weatherservice.persistence.entities.Administrator;

public class RetrieveAdministrators {

    @SuppressWarnings("unchecked")
    public boolean validAdministrator(Administrator admin) {
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("/home/zubergu/pzdatabase/PzCws.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();
	
	Query q = em.createQuery("SELECT a from Administrator a");
	
	List<Administrator> administrators = (List<Administrator>)q.getResultList();
	em.close();
	emf.close();
	return administrators.contains(admin);
    }
    
    @SuppressWarnings("unchecked")
    public List<Administrator> getAdministratorsList() {
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("/home/zubergu/pzdatabase/PzCws.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();
	
	Query q = em.createQuery("SELECT a from Administrator a");
	
	List<Administrator> administrators = (List<Administrator>)q.getResultList();
	em.close();
	emf.close();
	return administrators;
    }
    	
}
