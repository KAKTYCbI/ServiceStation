<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>" />
<H1>Добавление механика</H1>
</br>
<div class="reviews">
	<div class="review">
		<div class="reviewtop"></div>
		<div class="reviewcenter">
		<ul>
			<form:form method="post" action="addmechanic" commandName="mechanic">
				<table>
					<tr>
						<td><form:label path="name">Имя:</form:label></td>
						<td><form:input path="name" /></td>
						<td><form:errors path="name" cssClass="error"/></td>
					</tr>


					<tr>
						<td><form:label path="email">email:</form:label></td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssClass="error"/></td>
					</tr>

					<tr>
						<td><form:label path="contact">контакт:</form:label></td>
						<td><form:input path="contact" /></td>
						<td><form:errors path="contact" cssClass="error"/></td>
					</tr>
					<tr>
						<td><form:label path="sto">СТО:</form:label></td>
						<td><form:select  path="sto">
						  <c:forEach items="${stos}" var="stos" >
								<option path ="sto">${stos.name}</option>	
						  </c:forEach>
							</form:select></td>
					</tr>

					<tr>
						<td><form:label path="salary">зарплата:</form:label></td>
						<td><form:input path="salary" /></td>
						<td><form:errors path="salary" cssClass="error"/></td>
					</tr>

					<tr>
						<td><form:label path="password">пароль:</form:label></td>
						<td><form:input path="password" /></td>
						<td><form:errors path="password" cssClass="error"/></td>
					</tr>


					<tr>
						<td colspan="2"><input type="SUBMIT" value="Добавить механика"></td>
					</tr>

				</table>

			</form:form>
			</ul>
		</div>
	<div class = "reviewbottom"></div>
	</div>
</div>