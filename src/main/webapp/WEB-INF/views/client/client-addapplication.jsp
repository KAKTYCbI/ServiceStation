<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />

<h1>Добавление заявки</h1>
</br>
 <div class="reviews">
      <div class = "review">
         <div class = "reviewtop"></div>
            <div class = "reviewcenter">
<form:form method = "post" action = "addapplication" commandName = "application">
    <ul><table>
      <tr>
        <td>
          Имя:
        </td>
        <td>
          ${user.name }
        </td>
      </tr>
      <tr>
        <td>
          Email
        </td>
        <td>
         ${user.email }
        </td>
      </tr>
      <tr>
        <td>
          Контакт
        </td>
        <td>
          ${user.contact }
        </td>
      </tr>
            <tr>
        <td>
          <form:label path = "sto">СТО</form:label>
        </td>
        <td>
          <form:select path="sto">
          <c:forEach items="${stos}" var="stos" >
          <option path ="sto">${stos.name}</option>	
          </c:forEach>
          </form:select>
        </td>
        <td><form:errors path="sto" cssClass="error"/></td>
     
      
      </tr>
            <tr>
        <td>
          <form:label path = "services">Услуга</form:label>
        </td>
        <td>
          <form:select multiple="multiple" path="services">
          <<c:forEach items="${service}" var="service" >
          <option path ="services">${service.name}</option>	
          </c:forEach>
          </form:select>
        </td>
          <td><form:errors path="services" cssClass="error"/></td>
      </tr>

      <tr>
        <td colspan="2"><input type="SUBMIT" value="addapplication"></td>
      </tr>
    </table></ul>
</form:form>
            </div>
          <div class = "reviewbottom"></div>
          </div>
  </div>