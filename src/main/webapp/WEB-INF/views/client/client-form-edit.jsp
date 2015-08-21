<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1>Edit Client:</h1>

<form:form action="${action}" commandName="client"
	modelAttribute="client" method="POST">

	<form:label path="name">Name:</form:label>
	<form:input path="name" />
	<form:errors path="name" cssClass="error" />
	<br />

	<c:if test="${client.id > 0}">
		<form:label path="ssn">SSN:</form:label>
		<form:hidden path="ssn" /> ${client.ssn} <br />
		<br />
	</c:if>

	<c:if test="${client.id == 0}">
		<form:label path="ssn">SSN:</form:label>
		<form:input path="ssn" />
		<form:errors path="ssn" cssClass="error" />
		<br />
	</c:if>

	<br />
	<br />
		
	<form:label path="active">Is active:</form:label>
	<form:checkbox path="active" />
	<form:errors path="active" cssClass="error" />
	
	<br/><br/>

	<form:label path="notes">Notes:</form:label><br/>
	<form:textarea path="notes" />
	<form:errors path="notes" cssClass="error" />
	
	<br/><br/>
	
	<form:label path="country">Country:</form:label><br/>
	<form:select path="country" >
		<form:option value="NONE" label="--- Select ---" />
		
		<c:forEach var="country" items="${countryList}">
			
			<c:if test="${country.key eq client.country.id}">
				<option value="${country.key}" selected="selected">${country.value}</option>
			</c:if>
			
			<c:if test="${country.key ne client.country.id}">
				<option value="${country.key}">${country.value}</option>
			</c:if>
			
		</c:forEach>
	</form:select>
	<form:errors path="country" cssClass="error" />
	
	<br/><br/>
	
	<form:label path="multipleOptions">Multiple Options:</form:label><br/>
	<form:checkboxes items="${multipleOptionsList}" path="multipleOptions" cssStyle="margin: 0px 5px 0px 20px;" />
	<form:errors path="multipleOptions" cssClass="error" />
	
	<br/><br/>
	
	Radio Buttons:<br/>
	<form:radiobutton path="singleChoice" value="A1" /> Option 1
	<form:radiobutton path="singleChoice" value="A2" /> Option 2
	<form:errors path="singleChoice" cssClass="error" />

	<br/><br/>
	
	<form:label path="businessFields">Other Options:</form:label><br/>
	<form:select path="businessFields" items="${businessFieldList}" multiple="true" size="2"/>
	<form:errors path="businessFields" cssClass="error" />
		
	<br/><br/>	

	
	<input type="submit" value="Save" />
	<input type="reset" value="Cancel" onclick="window.history.back();"/>

</form:form>
