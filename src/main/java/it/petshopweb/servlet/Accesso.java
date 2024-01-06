package it.petshopweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.petshopweb.model.Utenti;

/**
 * Servlet implementation class Accesso
 */
@WebServlet("/Accesso")
public class Accesso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("PetShopWeb");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accesso() {
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
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
		    EntityManager entityManager = emFactory.createEntityManager();
		    TypedQuery<Utenti> query = entityManager.createQuery("SELECT u FROM Utenti u WHERE u.username = :username", Utenti.class);
		    query.setParameter("username", username);

		    List<Utenti> accessoUser = query.getResultList();

		    if (!accessoUser.isEmpty()) {
		        TypedQuery<Utenti> querypw = entityManager.createQuery("SELECT u FROM Utenti u WHERE u.username = :username AND u.password = :password", Utenti.class);
		        querypw.setParameter("username", username);
		        querypw.setParameter("password", password);

		        List<Utenti> accessoCheck = querypw.getResultList();
		       
		        if (!accessoCheck.isEmpty()) {
		        	 String contrAbilitato = accessoCheck.get(0).getStato();
		        	 if(contrAbilitato.contains("D")) {
		        		 response.sendRedirect("Login.jsp?bannato='banned'");
		        		 System.out.println("Utente Bannato");
		        		 
		        	 }else {
		            String ruolo = accessoCheck.get(0).getRuolo();
		            System.out.println("Ruolo: " + ruolo);

		            if (ruolo.contains("M")) {
		                response.sendRedirect("vista-manager.jsp");
		            } else {
		                response.sendRedirect("vista-utente.jsp");
		            }
		        	 }
		        } else {
		            try {
		            	String istantBan = accessoUser.get(0).getStato();
		            	 if(istantBan.contains("D")) {
		                    	response.sendRedirect("Login.jsp?bannato='banned'");
				        		 System.out.println("Utente Bannato");
		                    }else {
		            	 
		                entityManager.getTransaction().begin();
		                Query aggiornaLogin = entityManager.createQuery("UPDATE Utenti u SET u.loginRimanenti = u.loginRimanenti + :incremento WHERE u.username = :username");
		                aggiornaLogin.setParameter("username", username);
		                aggiornaLogin.setParameter("incremento", 1);
		                aggiornaLogin.executeUpdate();
		                entityManager.getTransaction().commit();
		                System.out.println("Aggiornati i login rimanenti");
		                response.sendRedirect("Login.jsp?pwerrata='password errata'");
		                
		                TypedQuery<Utenti> checkLogin = entityManager.createQuery("SELECT u FROM Utenti u WHERE u.username = :username ", Utenti.class);
		                checkLogin.setParameter("username", username);
		                List<Utenti> checkLoginUser = checkLogin.getResultList();
		                int logrimasti = checkLoginUser.get(0).getLoginRimanenti();
		               
		                if (logrimasti >= 3) {
		                    entityManager.getTransaction().begin();
		                    Query aggiornaStato = entityManager.createQuery("UPDATE Utenti u SET u.stato = :statoD WHERE u.username = :username");
		                    aggiornaStato.setParameter("username", username);
		                    aggiornaStato.setParameter("statoD", "D");
		                    aggiornaStato.executeUpdate();
		                    entityManager.getTransaction().commit();
		                    System.out.println("Aggiorno lo stato");
	                    }
		            }
		            } catch (Exception e) {
		                e.printStackTrace();
		                if (entityManager.getTransaction().isActive()) {
		                    entityManager.getTransaction().rollback();
		                }
		                
		            }
		        }
		    } else {
		        // Utente non trovato o le credenziali sono errate
		        System.out.println("Utente non trovato o credenziali errate");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
	         
	  
		doGet(request, response);
	}

}
