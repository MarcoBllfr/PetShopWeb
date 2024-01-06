<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="it.petshopweb.dao.UtentiDao, it.petshopweb.dao.UtentiDaoImpl" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    String userId = request.getParameter("id");

    if (userId != null && !userId.isEmpty()) {
        int id = Integer.parseInt(userId);
        UtentiDao utentiDao = new UtentiDaoImpl();
        utentiDao.delete(id);
        response.sendRedirect("vista-manager.jsp");
    } else {
        
        response.getWriter().println("ID utente non valido");
    }
%>
</body>
</html>