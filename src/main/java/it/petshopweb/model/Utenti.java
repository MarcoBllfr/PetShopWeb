package it.petshopweb.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the utenti database table.
 * 
 */
@Entity
@NamedQuery(name="Utenti.findAll", query="SELECT u FROM Utenti u")
public class Utenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UTENTI_IDUTENTI_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UTENTI_IDUTENTI_GENERATOR")
	private int idUtente;

	private String cellulare;

	private String cognome;

	@Temporal(TemporalType.DATE)
	@Column(name="dataNascita")
	private Date dataNascita;

	private String email;

	@Column(name="login_rimanenti")
	private int loginRimanenti;

	private String nome;

	private String password;

	private String ruolo;

	private String stato;

	private String username;

	public Utenti() {
	}

	public Utenti(int idUtente, String cellulare, String cognome, Date dataNascita, String email, int loginRimanenti,
			String nome, String password, String ruolo, String stato, String username) {
		super();
		this.idUtente = idUtente;
		this.cellulare = cellulare;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.email = email;
		this.loginRimanenti = loginRimanenti;
		this.nome = nome;
		this.password = password;
		this.ruolo = ruolo;
		this.stato = stato;
		this.username = username;
	}

	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getCellulare() {
		return this.cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLoginRimanenti() {
		return this.loginRimanenti;
	}

	public void setLoginRimanenti(int loginRimanenti) {
		this.loginRimanenti = loginRimanenti;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getStato() {
		return this.stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}