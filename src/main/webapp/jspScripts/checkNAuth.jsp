<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="c" items="<%= request.getCookies() %>">
	<c:if test='${c.getName() eq "usuario"}'>
		<c:if test='${c.getValue() ne ""}'>
			<c:redirect url="./Dashboard" />
		</c:if>
	</c:if>
</c:forEach>