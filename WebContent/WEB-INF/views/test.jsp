<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <c:forEach var="lc" items="${l}">
             	  
             	  <tr>
             	   <td>${lc.id_commande}</td>
             	   <td>${lc.chambre.n_chambre}</td>
             		  <td>
             		  <c:forEach var="c" items="${lc.ligne_commande}">
             		   ${c.qte} * ${c.name} </br>
             		  </c:forEach> 
					
					
                 
                  </c:forEach> 
</body>
</html>