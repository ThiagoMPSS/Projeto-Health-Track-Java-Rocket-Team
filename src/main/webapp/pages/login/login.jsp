<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Um aplicativo para monitoramento da saúde e realização de exercícios físicos">
<meta name="keyworks" content="saúde, exercícios físicos, bem-estar">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href='./assets/estilo/base.css'>
<link rel="stylesheet" href="./assets/estilo/login.css">
<title>Health Track - Login</title>
</head>
<body class="app-body">
	<%@ include file="/jspScripts/checkNAuth.jsp" %>
	<%@ include file="/components/Header.html"%>
	<main>
		<section class="container">
			<form action="./Auth" method="post" class="custom-form">
				<h3 class="custom-form-title">Faça seu login:</h3>
				<div class="form-group">
					<label for="usuario">Usuário</label> <input id="usuario"
						name="usuario" class="form-control" type="text" required>
				</div>
				<div class="form-group">
					<label for="senha">Senha</label> <input id="senha" name="senha"
						class="form-control" type="password" required>
				</div>
				<div class="d-grid gap-2">
					<button type="submit" class="custom-button">Login</button>
				</div>
			</form>
			<form action="./Auth" method="post" class="custom-form">
				<h3 class="custom-form-title">Ou crie uma nova conta:</h3>
				<div class="form-group">
					<label for="usuario">Usuário</label> <input id="usuario"
						name="usuario" class="form-control" type="text" required>
				</div>
				<div class="form-group">
					<label for="senha">Senha</label> <input id="senha" name="senha"
						class="form-control" type="password" required>
				</div>
				<div class="form-group">
					<label for="senha">Confirmar Senha</label> <input id="senha"
						class="form-control" type="password" required>
				</div>
				<div class="d-grid gap-2">
					<button type="submit" class="custom-button">Criar Conta</button>
				</div>
			</form>
		</section>
	</main>
	<%@ include file="/components/Footer.html"%>
</body>
</html>