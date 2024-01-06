package it.petshopweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.petshopweb.dao.UtentiDao;
import it.petshopweb.dao.UtentiDaoImpl;
import it.petshopweb.model.Utenti;

/**
 * Servlet implementation class Registra
 */
@WebServlet("/Registra")
public class Registra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		UtentiDao operazioneUtenti = new UtentiDaoImpl();
		Utenti utenteC = new Utenti();
		String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String password = request.getParameter("password");
        String cellulare = request.getParameter("cellulare");
        String email = request.getParameter("email");
        
       String datanascita = request.getParameter("dataNascita");
       java.sql.Date dataNascita = java.sql.Date.valueOf(datanascita);

     //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     //  LocalDate dataNascita = LocalDate.parse(datanascita, formatter);
       int counter = 0;
       String datausername = dataNascita.toString();
       String username = nome.substring(0, 2)+cognome.substring(0, 2)+datausername.substring(0, 4)+"_"+counter;
     boolean check = true;
     while(check) {
    	 if (operazioneUtenti.getByUsername(username) != null) {
    		 counter++;
    		 username = nome.substring(0, 2)+cognome.substring(0, 2)+datausername.substring(0, 4)+"_"+counter;
    	 }else{
    		 username = nome.substring(0, 2)+cognome.substring(0, 2)+datausername.substring(0, 4)+"_"+counter;
    		 utenteC.setUsername(username);
    		 check = false;
    	 }
     }
     utenteC.setDataNascita(dataNascita);
     //   utenteC.setDataNascita(java.sql.Date.valueOf(dataNascita));
        utenteC.setEmail(email);
        utenteC.setCellulare(cellulare);
        utenteC.setPassword(password);
        utenteC.setNome(nome);
		utenteC.setCognome(cognome);
		
		utenteC.setRuolo("G");
		utenteC.setStato("A");
		
		writer.append("\n<html><body><h1> Benvenuto "+utenteC.getUsername()+", la registrazione e' stata effettuata correttamente"
				+ "<p><a href=\"index.html\">Torna alla homepage</a></p>"
				+ "</h1></body></html> ");
		
	
		
		operazioneUtenti.insert(utenteC);
		doGet(request, response);
	}

}
