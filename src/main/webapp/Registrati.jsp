<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina REgistrazione</title>
</head>
<body>
<h2>Benvenuto Registrati pure</h2>
 <form action="Registra" method="post">
 <table>
			<tr>
       <td> Nome:</td> 
       <td><input type="text" name="nome" required/></td>
       </tr>
       <tr>
        <td>Cognome:</td> 
        <td><input type="text" name="cognome" required/></td>
        </tr>
        <tr>
        <td>Data di nascita:</td>
        <td> <input type="date" name="dataNascita" required/></td>
   		</tr>
   		<tr>
        <td>Password:</td>
        <td><input type="password" name="password" required/></td>
        </tr>
        
       <tr>
        <td>Cellulare:</td> 
        <td><input type="text" name="cellulare" /></td>
        </tr>
        
        <tr>
        <td>Email:</td> 
        <td><input type="email" name="email" required /></td>
        </tr>
        
        <tr>
       <td colspan="2"> <input type="submit" value="Registrati" /></td>
        </tr>
		</table>
    </form>
</body>
</html>