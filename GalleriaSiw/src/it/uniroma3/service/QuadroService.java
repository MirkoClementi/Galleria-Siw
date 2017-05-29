package it.uniroma3.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import it.uniroma3.model.Quadro;

// gestisce i servizi al db di un oggetto
public class QuadroService {
	private EntityManager em;

	
	public Quadro save(Quadro quadro) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(quadro);
		tx.commit();
		em.close();
		emf.close();
		return quadro;
	}
	
	public List<Quadro> findAll(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Quadro> query = em.createNamedQuery("findAllQuadri", Quadro.class);
		List<Quadro> quadri = query.getResultList();
		tx.commit();
		em.close();
		emf.close();
		return quadri;
	}
	
	public Quadro find(Long id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Quadro quadro = em.find(Quadro.class, id);
		tx.commit();
		em.close();
		emf.close();
		return quadro;
	}
	
	public void delete(Quadro quadro){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("galleria-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.contains(quadro)? quadro: em.merge(quadro));
		tx.commit();
		em.close();
		emf.close();
	}
}
