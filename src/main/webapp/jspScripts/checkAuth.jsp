<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="hasUser" scope="page" value="0"></c:set>
<c:forEach var="c" items="<%= request.getCookies() %>">
	<c:if test='${c.getName() eq "usuario"}'>
		<c:set var="hasUser" scope="page" value="1"></c:set>
		<c:if test='${c.getValue() eq ""}'>
			<c:redirect url="./Login?t=t"></c:redirect>
		</c:if>
	</c:if>
</c:forEach>
<c:if test='${hasUser eq "0"}'>
	<c:redirect url="./Login"></c:redirect>
</c:if>