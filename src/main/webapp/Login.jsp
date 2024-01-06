<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1>Inserisci i dati per effettuare il login</h1>
<form action="Accesso" method="post">
 <table>
 <%
 String errore1 = request.getParameter("bannato");
 String errore2 = request.getParameter("pwerrata");
 %>
  <%if(errore1 != null){%>
	 
	 <p>
     Account Bannato Contatta un admin
      </p>
 <%}%>
 <%if(errore2 != null){%>
	 
	 <p>
     Errore nella Password
      </p>
 <%}%>



       <tr>
        <td>Username:</td> 
        <td><input type="text" name="username" /></td>
        </tr>
        <tr>
        <td>Password:</td>
        <td><input type="password" name="password" required/></td>
        </tr>
        <tr>
       <td colspan="2"> <input type="submit" value="Accedi" /></td>
        </tr>
		</table>
    </form>
</body>
</html>