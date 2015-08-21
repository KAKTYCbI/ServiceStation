<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<security:authorize access="isAuthenticated()">
	<ul class="nav nav-pills nav-stacked">
		<li class="active"><a href="<c:url value='/client/list'/>"> Clients List</a></li>
		<li><a href="<c:url value='/client/list' />"> Menu Item 2</a></li>
		<li><a href="<c:url value='/client/list' />"> Menu Item 3</a></li>
		<li><a href="<c:url value='/client/list' />"> Another Operation</a></li>
	</ul>
</security:authorize>