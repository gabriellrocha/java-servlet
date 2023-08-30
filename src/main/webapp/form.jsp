<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novoUsuarioServlet" var="linkServletNovoUsuario"></c:url>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Formulário</title>
  </head>
  <body>
	<form method="post" action="${linkServletNovoUsuario}">
		
		Enviar a data no formato correto para não gerar exceção rs  ;)<br><br><br>
		
		<label for="usernome">Nome:</label>
		<input id=usernome type="text" name="nome">
		
		<label for="data-nasc">Data nascimento:</label>
		<input id="data-nasc" type="text" name="dataNascimento" placeholder="dd/MM/yyyy">
		
		<input type="submit" value="Enviar">
		
	 </form>
  </body>
</html>