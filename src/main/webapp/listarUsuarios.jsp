<%@page import="br.com.gabriel.entidades.Usuario"%>
<%@page import="br.com.gabriel.servlets.NovoUsuarioServlet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
	  <c:forEach items="${lista}" var="user">
		  <li>
		    ${user.nome} - ${user.dataNascimento}
		    <a href="mostrarUsuario?id=${user.id}">editar</a>
		    <a href="removerUsuario?id=${user.id}">remover</a>
	      </li>	   
	  </c:forEach>
	</ul> 
</body>
</html>