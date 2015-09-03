<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />
<h1>Дабавление заявок на деталь</h1>
</br>
 <div class="reviews">
      <div class = "review">
         <div class = "reviewtop"></div>
            <div class = "reviewcenter">
            <ul>
   <form:form method = "post" action = "addapplicationdetail" commandName = "applicationdetail">
    <table>
    <tr>
        <td>
          <form:label path = "application">Выберите заявку:</form:label>
        </td>
        <td>
          <form:select path="application">
          <c:forEach items="${applications}" var="applications" >
			<option path ="application">${applications.id}</option>	
		  </c:forEach>
        </form:select>
        </td>
        <td><form:errors path="application" cssClass="error"/></td>
      </tr> 
   
      <tr>
        <td>
          <form:label path = "name">Название детали:</form:label>
        </td>
        <td>
          <form:input path="name"/>
        </td>
          <td><form:errors path="name" cssClass="error"/></td>
      </tr>
      
      <tr>
        <td colspan="2"><input type="SUBMIT" value="addapplicationdetail"></td>
      </tr>
    </table>
</form:form>
            
            </ul>
            </div>
          <div class = "reviewbottom"></div>
          </div>
  </div>