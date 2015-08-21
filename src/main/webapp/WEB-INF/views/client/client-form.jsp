<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1><spring:message code="new.client"/>: </h1>
 
<form:form action="${action}" commandName="client" modelAttribute="client" method="POST">

	<form:errors path="*" cssClass="errorblock" element="div" />
	
	<form:input path="name" /> <form:errors path="name" cssClass="error" /> <br/>
	
	<c:if test="${client.id > 0}" >
	<form:label path="ssn">SSN:</form:label>
	<form:hidden path="ssn" /> ${client.ssn} <br/><br/>
	</c:if>
	
	<c:if test="${client.id == 0}" >
	  <form:label path="ssn">SSN:</form:label> <form:input path="ssn"/>
	  <form:errors path="ssn"/> <br/><br/>
    </c:if>	 
    
  	<input type="submit" value="Save" />
	<input type="reset" value="Cancel" onclick="window.history.back();"/>
  
</form:form> 
