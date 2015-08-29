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
            <ul>
             №: ${application.id }</br>
             Name: ${application.client.name }</br>
             Email: ${application.client.email }</br>
             Контакт: ${application.client.contact }</br>
             Механик: ${application.mechanic.name }</br>
             СТО:${application.sto.name }</br>
             Услуги:
             <c:forEach items="${application.services}" var="service" > 
             ${service.name}</br>
             </c:forEach></br> 
             Детали:</br>
             Дата:<fmt:formatDate value="${application.dateOrder }" pattern="dd-MM-yyyy" /></br>
             Стоимость:${application.price }</br>
            </ul>
            </div>
          <div class = "reviewbottom"></div>
          </div>

  </div>