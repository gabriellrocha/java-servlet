<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="atualizarUsuario?id=${usuario.id}" method="post">
	    Enviar a data no formato correto para não gerar exceção rs  ;)<br><br><br>
		
		<label for="usernome">Nome:</label>
		<input id=usernome type="text" name="nome" value="${usuario.nome}">
		
		<label for="data-nasc">Data nascimento:</label>
		<input id="data-nasc" type="text" name="dataNascimento" placeholder="dd/MM/yyyy" value="${usuario.dataNascimento}">
		
		<input type="submit" value="Enviar">
	  
	</form>
	
</body>
</html>