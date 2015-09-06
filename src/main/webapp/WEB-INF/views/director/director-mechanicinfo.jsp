<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>" />
<H1>Информация о механике</H1>
</br>
<div class="reviews">
	<div class="review">
		<div class="reviewtop"></div>
		<div class="reviewcenter">
		<ul>	<form:form method="post" action="../updatemechanic/${mechanic.userId }" commandName="mechanic">
				<table>
				    <tr>
				        <td><form:label path="userId">№:</form:label></td>
		                <td><form:input readonly="true" type="text" path="userId" value="${mechanic.userId }" /></td>
                    </tr>
					<tr>
						<td><form:label path="name">Имя:</form:label></td>
						<td><form:input path="name" /></td>
						
					</tr>


					<tr>
						<td><form:label path="email">email:</form:label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><form:label path="contact">контакт:</form:label></td>
						<td><form:input path="contact" /></td>
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
						
					</tr>

					<tr>
						<td><form:label path="password">пароль:</form:label></td>
						<td><form:input path="password" /></td>
					S
					</tr>


					<tr>
						<td><input type="SUBMIT" value="Обновить"></td>
						<td><a href="<c:url value='/director/addsalary/${mechanic.userId }' />">Выдать зарплату</a></td>
						
					</tr>

				</table>

			</form:form></ul>
		</div>
	<div class = "reviewbottom"></div>
	</div>
</div>