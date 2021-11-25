<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
					<jsp:useBean id="dao" class="com.RocketTeam.dao.Imc_DAO" />
					<% Object[] itens = dao.getByFk(1); %>
					<c:set scope="page" var="itens" value="<%= itens %>"/>
					<c:set scope="page" var="itensCount" value="<%= itens.length %>"/>
					<c:if test="${itensCount < 1}">
						<td colspan="5" style="text-align: center">Nenhum item encontrado!</td>
					</c:if>
					<c:forEach items="${itens}" var="item" >
						<tr>
							<th scope="row"><c:out value="${item.getDt_atualizacao()}" /></th>
							<td scope="col"><c:out value="${item.getNr_peso()}" /></td>
							<td scope="col"><c:out value="${item.getNr_altura()}" /></td>
							<td scope="col"><c:out value="${item.getIMC_value()}" /></td>
							<td scope="col">
								<div class="d-flex gap-2">
									<button class="btn btn-light" onClick="location.href='./DadosGerais/Edit?id=${item.getPK()}'">Editar</button>
									<button class="btn btn-danger" onClick="location.href='./DadosGerais/Delete/CRUD?id=${item.getPK()}'">Deletar</button>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
	<%@ include file="/components/Footer.html"%>
</body>
</html>