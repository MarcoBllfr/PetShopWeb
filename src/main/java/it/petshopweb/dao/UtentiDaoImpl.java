package it.petshopweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.petshopweb.model.Utenti;

public class UtentiDaoImpl implements UtentiDao {
	  private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("PetShopWeb");
	  
	@Override
	public List<Utenti> getAll() {
		EntityManager entityManager = emFactory.createEntityManager();
	        try {
	            TypedQuery<Utenti> query = entityManager.createQuery("SELECT u FROM Utenti u", Utenti.class);
	            return query.getResultList();
	        } finally {
	            entityManager.close();
	        }
	}

	@Override
	public Utenti getAllById(int idUtente) {
		EntityManager entityManager = emFactory.createEntityManager();
		    try {
		        TypedQuery<Utenti> query = entityManager.createQuery("SELECT u FROM Utenti u WHERE u.idUtente = :idUtente", Utenti.class);
		        query.setParameter("idUtente", idUtente);
		        return query.getSingleResult();
		    } finally {
		        entityManager.close();
		    }
	}

	@Override
	public void insert(Utenti utenti) {
		EntityManager entityManager = emFactory.createEntityManager();
	        EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            entityManager.persist(utenti);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null && transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace(); 
	        } finally {
	            entityManager.close();
	        }

	}

	@Override
	public void update(Utenti utenti) {
	EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(utenti);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); 
        } finally {
            entityManager.close();
        }

	}

	@Override
	public void delete(int idUtente) {
	 EntityManager entityManager = emFactory.createEntityManager();
	        EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            Utenti utenti = entityManager.find(Utenti.class, idUtente);
	            entityManager.remove(utenti);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null && transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace(); 
	        } finally {
	            entityManager.close();
	        }
	    }

	@Override
	public Utenti getByUsername(String username) {

     EntityManager entityManager = emFactory.createEntityManager();
     try {
         TypedQuery<Utenti> query = entityManager.createQuery("SELECT u FROM Utenti u WHERE u.username = :username", Utenti.class);
         query.setParameter("username", username);

         // Restituisce il primo risultato o null se non trova corrispondenze
         return query.getResultList().stream().findFirst().orElse(null);
     } finally {
         entityManager.close();
     }
 }

	}


