<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="it.petshopweb.dao.UtentiDao, it.petshopweb.dao.UtentiDaoImpl, it.petshopweb.model.Utenti,java.time.LocalDate,
 java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Modifiche effettuate</h1>
<% 
Utenti utenteAgg = new Utenti();
String userId = request.getParameter("id");
int idUtente = Integer.parseInt(userId);
String nome = request.getParameter("nome");
String email = request.getParameter("email");
String cognome = request.getParameter("cognome");
String cellulare = request.getParameter("cellulare");
String password = request.getParameter("password");
String stato = request.getParameter("stato");
String ruolo = request.getParameter("ruolo");
String datanascita = request.getParameter("dataNascita");
String username = request.getParameter("username");
String loginrimanenti = request.getParameter("loginrimaneti");
int logrimasti = Integer.parseInt(loginrimanenti);

java.sql.Date dataNascita = java.sql.Date.valueOf(datanascita);

utenteAgg.setDataNascita(dataNascita);
utenteAgg.setUsername(username);
utenteAgg.setIdUtente(idUtente);
utenteAgg.setNome(nome);
utenteAgg.setEmail(email);
utenteAgg.setCellulare(cellulare);
utenteAgg.setPassword(password);
utenteAgg.setStato(stato);
utenteAgg.setRuolo(ruolo);
utenteAgg.setCognome(cognome);
utenteAgg.setLoginRimanenti(logrimasti);
UtentiDao utentiDao = new UtentiDaoImpl();
   utentiDao.update(utenteAgg);
 
 %>
 <p><a href="index.html">Torna alla homepage</a></p>
 <p><a href="vista-manager.jsp">Torna alla schermata admin</a></p>
</body>
</html>