<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://kit.fontawesome.com/f18158c171.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap" rel="stylesheet">

<nav class="navbar navbar-expand-lg navbar-light border-bottom py-4">
  <div class="container-fluid">
    <a class="navbar-brand fw-bold" href="<%= request.getContextPath() %>/Dashboard">Health Track</a>
    <button
      class="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
        	<c:choose>
	        	<c:when test='<%= request.getServletPath().equals("/Dashboard") %>'>
	          		<a class="nav-link active" aria-current="page" href="<%= request.getContextPath() %>/Dashboard">Dados</a>
	          	</c:when>
	          	<c:otherwise>
	          		<a class="nav-link" href="<%= request.getContextPath() %>/Dashboard">Dados</a>
	          	</c:otherwise>
          	</c:choose>
        </li>
        <li class="nav-item">
        	<c:choose>
	        	<c:when test='<%= request.getServletPath().equals("/Refeicoes") %>'>
	          		<a class="nav-link active" aria-current="page" href="<%= request.getContextPath() %>/Refeicoes">Refeições</a>
	          	</c:when>
	          	<c:otherwise>
	          		<a class="nav-link" href="<%= request.getContextPath() %>/Refeicoes">Refeições</a>
	          	</c:otherwise>
          	</c:choose>
        </li>
        <li class="nav-item">
        	<c:choose>
	        	<c:when test='<%= request.getServletPath().equals("/Exercicios") %>'>
	          		<a class="nav-link active" aria-current="page" href="<%= request.getContextPath() %>/Exercicios">Exercícios</a>
	          	</c:when>
	          	<c:otherwise>
	          		<a class="nav-link" href="<%= request.getContextPath() %>/Exercicios">Exercícios</a>
	          	</c:otherwise>
          	</c:choose>
        </li>
        <li class="nav-item">
        	<c:choose>
	        	<c:when test='<%= request.getServletPath().equals("/Pressao") %>'>
	          		<a class="nav-link active" aria-current="page" href="<%= request.getContextPath() %>/Pressao">Pressão</a>
	          	</c:when>
	          	<c:otherwise>
	          		<a class="nav-link" href="<%= request.getContextPath() %>/Pressao">Pressão</a>
	          	</c:otherwise>
          	</c:choose>
        </li>
      </ul>
    </div>
  </div>
  <div class="dropstart">
    <i class="far fa-user-circle fs-3 me-3 dropdown" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false"></i>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
      <a class="dropdown-item" href="#">Meu Perfil</a>
      <a class="dropdown-item" href="./Logout">Sair</a>
    </div>
  </div>
</nav>
<script
  src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
  crossorigin="anonymous"
></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
