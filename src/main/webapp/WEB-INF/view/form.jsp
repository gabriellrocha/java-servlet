<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/usuarios?action=criar" var="linkServlet"></c:url>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Formulário</title>
  </head>
  <body>
  	
  	<c:import url="logout-parcial.jsp"></c:import>
	<form action="${linkServlet}" method="post">
		
		<label for="usernome">Nome:</label>
		<input id=usernome type="text" name="nome">
		
		<label for="data-nasc">Data nascimento:</label>
		<input id="data-nasc" type="text" name="dataNascimento" placeholder="dd/MM/yyyy">
		
		<input type="submit" value="Enviar">
		
	 </form>
  </body>
</html>