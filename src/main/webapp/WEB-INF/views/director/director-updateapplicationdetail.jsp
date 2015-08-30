<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />

<h1>Заявки на детали</h1>
</br>
 <div class="reviews">
      <div class = "review">
         <div class = "reviewtop"></div>
            <div class = "reviewcenter">
            <ul>
<form:form method = "post" action = "updateapplicationdetail" commandName = "applicationdetail">
    <table>
      <tr>
        <td><form:label path="id">№:</form:label></td>
		<td><form:input readonly="true" type="text" path="id" value="${applicationdetail.id }" /></td>
      </tr>
      <tr>
        <td>
          <form:label path = "name">Название детали</form:label>
        </td>
        <td>
         ${applicationdetail.name}
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "dateDelivery">Дата поступления:</form:label>
        </td>
        <td>
           <form:input type="date" path="dateDelivery"/>
           
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "dateOrder">Дата заявки:</form:label>
        </td>
        <td>
          <fmt:formatDate value="${applicationdetails.dateOrder }" pattern="dd-MM-yyyy" />
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "status">Статус:</form:label>
        </td>
        <td>
         <form:select path="status">
          <form:option value="status" label="${applicationdetails.status.status }" />
          <c:forEach items="${statuss}" var="statuss" >
          <c:if test="${applicationdetails.status.status ne statuss.status}">
			<option path ="status">${statuss.status}</option>	
		</c:if>
		 </c:forEach>
        </form:select>
        </td>
      </tr>
      
      <tr>
        <td colspan="2"><input type="SUBMIT" value="updateapplicationdetail"></td>
      </tr>
    </table>
  </form:form></ul>
  </div>
  <div class = "reviewbottom"></div>
          
 </div>        
  </div>