<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<%
  // scriptlet
  String nome = (String) request.getAttribute("nomeUsuario");
%>
<!DOCTYPE html>
 <html>
   <head>
     <meta charset="UTF-8">
     <title>Inicio</title>
   </head>
  <body>
	
	<c:if test="${not empty nomeUsuario}">
	  <p>Usuario ${nomeUsuario} cadastrado com sucesso!</p>
	</c:if>
	
	<c:if test="${empty nomeUsuario}">
	  <p>Nenhum usuario cadastrado!</p>
	</c:if>
  </body>
</html>