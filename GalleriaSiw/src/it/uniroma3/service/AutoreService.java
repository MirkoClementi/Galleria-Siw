package it.uniroma3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import it.uniroma3.model.Autore;

public class AutoreService {
	private EntityManager em;

	
	public Autore save(Autore autore) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(autore);
		tx.commit();
		em.close();
		emf.close();
		return autore;
	}
	
	public List<Autore> findAll(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Autore> query = em.createNamedQuery("findAllAutori", Autore.class);
		List<Autore> autori = query.getResultList();
		tx.commit();
		em.close();
		emf.close();
		return autori;
	}
	
	public Autore find(Long id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Autore autore = em.find(Autore.class, id);
		tx.commit();
		em.close();
		emf.close();
		return autore;
	}
	
	public void delete(Autore autore){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.contains(autore)? autore: em.merge(autore));
		tx.commit();
		em.close();
		emf.close();
	}
}
