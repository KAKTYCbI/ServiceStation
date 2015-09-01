<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />

<h1>Список СТО</h1>
</br>
 <div class="reviews">
 <c:forEach items="${sto}" var="sto" >
      <div class = "review">
         <div class = "reviewtop"></div>
            <div class = "reviewcenter">
                 <div class="rating">
                 <ul><fmt:formatNumber value=" ${sto.rating }" maxFractionDigits="2"/></ul>
               </div>
            <ul>Name: ${sto.name }</ul> </br>
            </div>
          <div class = "reviewbottom"></div>
          </div>
          </c:forEach>
  </div>