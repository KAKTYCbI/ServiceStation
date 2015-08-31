<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />

<h1>Список СТО</h1>
</br>
 <div class="reviews">
 <c:forEach items="${sto}" var="sto" >
      <div class = "review">
         <div class = "reviewtop"></div>
            <div class = "reviewcenter">
                 <div class="rating">
                 <ul>${sto.rating }</ul>
               </div>
               </br>
            <ul>Название:${sto.name}&nbsp;
            Стоимость аренда:${sto.price }&nbsp;
            <a href="<c:url value="/director/mechaniclistbysto/${sto.id }" />">Список механиков</a></ul> </br>
            <a href="<c:url value="/director/updatesto/${sto.id }" />">Обновить</a></ul> </br>
            
            </div>
          <div class = "reviewbottom"></div>
          </div>
  </c:forEach>
  </div>