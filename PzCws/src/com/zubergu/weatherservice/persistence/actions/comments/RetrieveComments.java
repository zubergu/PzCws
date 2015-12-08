package com.zubergu.weatherservice.persistence.actions.comments;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.zubergu.weatherservice.persistence.entities.Comment;

public class RetrieveComments {
    @SuppressWarnings("unchecked")
    public List<Comment> retrieveLastComments(Integer numberOfComments) {
	EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("$objectdb/localhost/PzCws.odb");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();
	
	Query q = em.createQuery("SELECT c from Comment c order by c.cid DESC");
	q.setMaxResults(numberOfComments);
	List<Comment> lastComments = (List<Comment>)q.getResultList();
	em.close();
	emf.close();
	return lastComments;
    }
}
