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
<title>Adicionar Atividade</title>
</head>
<body>
	<%@ include file="/jspScripts/checkAuth.jsp"%>
	<%@ include file="/components/navbar.jsp"%>
	<main>
		<div class="container border p-4 rounded my-3 restrict-sm">
			<form action="./Add/CRUD" method="POST">
				<!-- <div class="mb-3">
					<label for="atividade" class="form-label">Atividade</label> <input
						type="text" name="atividade" class="form-control">
				</div> -->
				<div class="mb-3">
					<label for="ds_frequencia_ati_fis" class="form-label">Série</label> <input
						type="text" name="ds_frequencia_ati_fis" id="ds_frequencia_ati_fis" class="form-control">
				</div>
				<div class="mb-3">
					<label for="dt_atividade" class="form-label">Data</label> <input
						type="date" name="dt_atividade" id="dt_atividade" class="form-control">
				</div>
				<button type="submit" class="custom-button">Enviar</button>
			</form>
		</div>
	</main>
	<%@ include file="/components/Footer.html"%>
</body>
</html>