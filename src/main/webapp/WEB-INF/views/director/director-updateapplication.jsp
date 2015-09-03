<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />
<h1>Информация о заявке</h1>
</br>
 <div class="reviews">

      <div class = "review">
         <div class = "reviewtop"></div>
            <div class = "reviewcenter">
     <form:form method = "post" action = "../updateapplication/${application.id }" commandName = "application">
   
     <ul>
      <table>
      <tr>
        <td><form:label path="id">№:</form:label></td>
		<td><form:input path="id" value="${application.id }" readonly="true"/></td>
      </tr>
       
       <tr>
        <td>
          Name:
        </td>
        <td>
          ${application.client.name }
        </td>
      </tr>
       <tr>
        <td>
          Email:
        </td>
        <td>
          ${application.client.email }
        </td>
      </tr>
       <tr>
        <td>
          Контакт:
        </td>
        <td>
          ${application.client.contact }
        </td>
      </tr> 
       <tr>
        <td>
          <form:label path = "mechanic">Механик:</form:label>
        </td>
        <td>
          <form:select path="mechanic">
          <form:option value="mechanic" label="${application.mechanic.name }" />
          <c:forEach items="${mechanics}" var="mechanics" >
          <c:if test="${application.mechanic.name ne mechanics.name}">
								<option path ="mechanic">${mechanics.name}</option>	
		  </c:if>
		  </c:forEach>
          </form:select>
        </td>
        <td><form:errors path="mechanic" cssClass="error" /></td>
      </tr>   
      <tr>
        <td>
          <form:label path = "status">Статус:</form:label>
        </td>
        <td>
          <form:select path="status">
          
          <c:forEach items="${statuss}" var="statuss" >
          <c:if test="${application.status.status ne statuss.status}">
			<option path ="status">${statuss.status}</option>	
		  </c:if>
		  </c:forEach>
		
		 <option path="status" >${application.status.status}</option>
        </form:select>
        </td>
        <td><form:errors path="status" cssClass="error" /></td>
      </tr> 
      <tr>
        <td>
          <form:label path = "sto">сто:</form:label>
        </td>
        <td>
          ${application.sto.name }
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "services">Услуги:</form:label>
        </td>
        <td>
          <c:forEach items="${application.services}" var="service" > 
             ${service.name}</br>
           </c:forEach></br> 
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "details">Детали:</form:label>
        </td>
        <td>
          <c:forEach items="${application.details}" var="detail" > 
             ${detail.name}</br>
             </c:forEach></br> 
        </td>
      </tr>
      <tr>
        <td>
          Дата заявки
        </td>
        <td>
        <fmt:formatDate value="${application.dateOrder }" pattern="dd-MM-yyyy" />
         
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "dateCompletion">Дата выполнение заявки:</form:label>
        </td>
        <td>
          <fmt:formatDate value="${application.dateCompletion }" pattern="dd-MM-yyyy" />
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "price">стоимость:</form:label>
        </td>
        <td>
          ${application.price }
        </td>
      </tr>
      <tr>
        <td colspan="2"><input type="SUBMIT" value="updateapplication"></td>
      </tr>          
              </table>
            </ul>
            
            </form:form>
            </div>
          <div class = "reviewbottom"></div>
          </div>
    
  </div>