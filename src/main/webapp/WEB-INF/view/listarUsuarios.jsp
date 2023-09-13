<%@page import="br.com.gabriel.modelo.entidades.Usuario"%>
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
	
	<h1> Usuário logado: ${usuarioLogado.login} </h1>
	
	<ul>
	  <c:forEach items="${lista}" var="user">
		  <li>
		    <p>
		      ${user.nome} - ${user.dataNascimento}
		      <a href="usuarios?action=exibir&id=${user.id}"><button>editar</button></a>
		      <a href="usuarios?action=excluir&id=${user.id}"><button>remover</button></a>
		    </p>
	      </li>	   
	  </c:forEach>
	</ul>
	
	<a href="usuarios?action=novo"><button>Novo Usuario</button></a>
</body>
</html>