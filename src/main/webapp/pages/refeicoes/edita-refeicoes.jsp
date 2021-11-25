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
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="../assets/estilo/base.css">
<title>Editar Refeicão</title>
</head>
<body>
	<%@ include file="/jspScripts/checkAuth.jsp"%>
	<%@ include file="/components/navbar.jsp"%>
	<main>
		<jsp:useBean id="dao" class="com.RocketTeam.dao.RefeicaoDAO" />
		<div class="container border p-4 rounded my-3 restrict-sm">
			<form action="./Edit/CRUD" method="POST">
				<c:set scope="page" var="item" value='<%= dao.get(Long.parseLong(request.getParameter("id"))) %>' />
				<input style="display:none" name="id" value="<%= request.getParameter("id") %>">
				<div class="mb-3">
					<label for="ds_alimento" class="form-label">Alimento</label> <input
						type="text" name="ds_alimento" class="form-control" value="${item.getDs_alimento()}">
				</div>
				<div class="mb-3">
					<label for="nr_calorias" class="form-label">Calorias</label> <input
						type="text" name="nr_calorias" class="form-control" value="${item.getNr_calorias()}">
				</div>
				<button type="submit" class="custom-button">Editar</button>
			</form>
		</div>
	</main>
	<%@ include file="/components/Footer.html"%>
</body>
</html>