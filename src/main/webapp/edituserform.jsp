<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="it.petshopweb.dao.UtentiDao, it.petshopweb.dao.UtentiDaoImpl , it.petshopweb.model.Utenti, java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String userId = request.getParameter("id");
UtentiDao utentiDao = new UtentiDaoImpl();
	Utenti u = utentiDao.getAllById(Integer.parseInt(userId));
	%>

	<h1>Edit Form</h1>
	<form action="edituser.jsp" method="post">
		<input type="hidden" name="id" value="<%=u.getIdUtente()%>" />
		<input type="hidden" name="username" value="<%=u.getUsername()%>" />
		
		
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="nome" value="<%=u.getNome()%>" /></td>
			</tr>
			
			<tr>
				<td>Cognome:</td>
				<td><input type="text" name="cognome" value="<%=u.getCognome()%>" /></td>
			</tr>
			
			<tr>
			<td>Email:</td>
			<td><input type="text" name="email" value="<%=u.getEmail()%>" /></td>
			</tr>
			
			<tr>
			<td>Cellulare:</td>
				<td><input type="text" name="cellulare" value="<%=u.getCellulare()%>" /></td>
			</tr>
			
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					value="<%=u.getPassword()%>" /></td>
			</tr>
			
			<tr>
				<td>Stato:</td>
				<td><input type="text" name="stato"
					value="<%=u.getStato()%>" /></td>
			</tr>
			
			<tr>
			<td>Ruolo:</td>
				<td><input type="text" name="ruolo"
					value="<%=u.getRuolo()%>" /></td>
			</tr>
			
			<tr>
			<td>Numero login:</td>
			<td><input type="text" name="loginrimaneti"
					value="<%=u.getLoginRimanenti()%>" /></td>
				</tr>
				<tr>
				<td>Data di nascita</td>
				<td> <input type="date" name="dataNascita" value="<%=u.getDataNascita()%>" /></td>
				</tr>
				
				<tr>
				<td colspan="2"><input type="submit" value="Salva" /></td>
			</tr>
		</table>
	</form>
</body>
</html>