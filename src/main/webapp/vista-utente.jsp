<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page import="it.petshopweb.dao.UtentiDao,it.petshopweb.dao.UtentiDaoImpl,it.petshopweb.model.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
<%
UtentiDao operazioneUtenti = new UtentiDaoImpl();
List<Utenti> lista = operazioneUtenti.getAll();
request.setAttribute("list",lista);
%>
<table border="1" width="90%">
<tr><th>Id</th><th>Name</th><th>Cognome</th><th>Password</th><th>Email</th><th>cellulare</th><th>Ruolo</th><th>Stato</th></tr>
<c:forEach items="${list}" var="u">
	<tr><td>${u.getIdUtente()}</td><td>${u.getNome()}</td><td>${u.getCognome()}</td><td>${u.getPassword()}</td><td>${u.getEmail()}</td><td>${u.getCellulare()}</td><td>${u.getRuolo()}</td><td>${u.getStato()}</td></tr>
</c:forEach>
</table>

</body>
</html>