<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
  // scriptlet
  String nome = (String) request.getAttribute("nomeUsuario");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bem-vindo(a)</title>
</head>
<body>
	
	 <p>
	  Usuario ${nomeUsuario} cadastrado com sucesso!
	 </p>
</body>
</html>