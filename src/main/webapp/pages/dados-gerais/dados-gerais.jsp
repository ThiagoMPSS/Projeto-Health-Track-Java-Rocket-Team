<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="./assets/estilo/base.css">
	<title>Dados Gerais</title>
</head>
<body>
	<%@ include file="/jspScripts/checkAuth.jsp" %>
	<%@ include file="/components/navbar.jsp" %>
	<main>
		<div class="container restrict-md">
			<div class="my-3">
				<button class="custom-button" onclick="location.href='./DadosGerais/Add'">Adicionar Dados</button>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Data</th>
						<th scope="col">Peso</th>
						<th scope="col">Altura</th>
						<th scope="col">IMC</th>
						<th scope="col">Ação</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">15/09/2021</th>
						<td scope="col">84kg</td>
						<td scope="col">1.80</td>
						<td scope="col">00.00</td>
						<td scope="col">
							<div class="d-flex gap-2">
								<button class="btn btn-light" onClick="location.href='./DadosGerais/Edit?id=1'">Editar</button>
								<button class="btn btn-danger" onClick="location.href='./DadosGerais/Delete?id=1'">Deletar</button>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row">15/10/2021</th>
						<td scope="col">84kg</td>
						<td scope="col">1.80</td>
						<td scope="col">00.00</td>
						<td scope="col">
							<div class="d-flex gap-2">
								<button class="btn btn-light">Editar</button>
								<button class="btn btn-danger">Deletar</button>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row">15/11/2021</th>
						<td scope="col">84kg</td>
						<td scope="col">1.80</td>
						<td scope="col">00.00</td>
						<td scope="col">
							<div class="d-flex gap-2">
								<button class="btn btn-light">Editar</button>
								<button class="btn btn-danger">Deletar</button>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</main>
	<%@ include file="/components/Footer.html"%>
</body>
</html>