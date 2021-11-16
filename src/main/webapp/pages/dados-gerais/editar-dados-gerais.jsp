<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="../assets/estilo/base.css">
<title>Editar Dados</title>
</head>
<body>
	<%@ include file="/jspScripts/checkAuth.jsp" %>
	<%@ include file="/components/navbar.jsp" %>
	<main>
		<div class="container border p-4 rounded my-3 restrict-sm">
			<form action="./Edit/CRUD" method="POST">
				<div class="mb-3">
					<label for="peso" class="form-label">Peso</label> <input
						type="number" name="peso" class="form-control"
						id="exampleInputEmail1" aria-describedby="emailHelp">
				</div>
				<div class="mb-3">
					<label for="altura" class="form-label">Altura</label> <input
						type="number" name="altura" class="form-control"
						id="exampleInputPassword1">
				</div>
				<button type="submit" class="custom-button">Editar</button>
			</form>
		</div>
	</main>
	<%@ include file="/components/Footer.html" %>
</body>
</html>