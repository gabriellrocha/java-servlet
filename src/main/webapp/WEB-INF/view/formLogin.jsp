<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/usuarios?action=login" var="linkServlet"></c:url>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Formulário</title>
  </head>
  <body>
  
	<form action="${linkServlet}" method="post">
		
		<label for="id-login">Login:</label>
		<input id=id-login type="text" name="login">
		
		<label for="id-senha">Senha:</label>
		<input id="id-senha" type="password" name="senha">
		
		<input type="submit" value="Enviar">
		
	 </form>
  </body>
</html>