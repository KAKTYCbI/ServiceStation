<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/header.css"/>" />

<security:authentication var="principalCopy" property="principal" />

<security:authorize access="hasRole('ROLE_ADMIN') and isAuthenticated()">
	<c:set var="principal" value="${pageContext.request.userPrincipal}" />
	<!-- ${principal} -->
</security:authorize>

<div class="navbar navbar-default" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="<c:url value="/login"/>">Clients Manager</a>
			<c:if test="${not empty principalCopy}">
				<a class="navbar-brand" href="<c:url value="/client/list" />">View Clients</a>
			</c:if>
		</div>
		
		<ul class="nav navbar-nav navbar-right">
	 	<security:authorize access="isAuthenticated()">
	       
	        <security:authorize access="hasRole('ROLE_ADMIN') and isAuthenticated()">
	            <li><a href="<c:url value="/admin/panel"/>">Admin Control Panel</a></li>
	        </security:authorize>
	       
	        <security:authorize access="hasRole('ROLE_USER')">
	            <li><a href="<c:url value="/user/extra"/>">User Extra Menu</a></li>
	        </security:authorize>
	       
	        <li><a href="<c:url value="/profile" />">Profile (${user.name})</a></li>
	       
	        <c:url var="logoutUrl" value='/j_spring_security_logout'/>
	        <li><a href="${logoutUrl}">Logout</a></li>
     	</security:authorize>
	    </ul>
	</div>
</div>