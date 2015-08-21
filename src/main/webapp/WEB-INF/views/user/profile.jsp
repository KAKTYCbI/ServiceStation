<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div align="right">
	<c:set var="currentLocale">${pageContext.response.locale}</c:set>
	<c:set var="localeCode" value="${fn:toUpperCase(currentLocale)}" />
	
	<c:set var="availLanguages" value="EN,DE,RU,FR" />
	<c:if test="${!fn:contains(availLanguages, localeCode)}">
	  <c:set var="localeCode" value="EN" />
	</c:if>
	
 	<c:forEach var="lang" items="${availLanguages}">
 	    <c:set var="langHTML" value="${lang}" />
	 	<c:if test="${lang eq localeCode}">
		  <c:set var="langHTML" value="<b><u>${lang}</u></b>" />
		</c:if>
    	<a href="${currentPage}?lang=${lang}">${langHTML}</a> &nbsp;
	</c:forEach>
</div>

<h1>User Profile: </h1>

<security:authorize access="isAuthenticated()">
   ${user.name} (${user.login}) / ID: ${user.userId}
</security:authorize> 

<br/><br/>

i18n is working: <spring:message code="test.message" />

<br/><br/>
<br/><br/>

