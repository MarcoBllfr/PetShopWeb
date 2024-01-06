package it.petshopweb.dao;

import java.util.List;


import it.petshopweb.model.Utenti;

public interface UtentiDao {
	List<Utenti> getAll();
	Utenti getAllById(int idUtente);
	Utenti getByUsername(String username);
	 void insert(Utenti utenti);
	 void update(Utenti utenti);
	 void delete(int idUtente);
}
