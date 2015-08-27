<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />
<h1>Отзывы</h1>
</br>
 <div class="reviews">
   <c:forEach items="${reviews}" var="reviews" >
      <div class = "review">
         <div class = "reviewtop"></div>
            <div class = "reviewcenter">

               <div class="rating">
                 <ul>${reviews.rating}</ul>
               </div>
            <ul>${reviews.client.name }, оставил отзыв</br>
             О ${reviews.sto.name} и ${reviews.mechanic.name}</br>
             ${reviews.text}.............................................................
             ..................................................</br>
             Дата отзыва:<fmt:formatDate value="${reviews.date}" pattern="dd-MM-yyyy" /></br>
            </ul>
            </div>
          <div class = "reviewbottom"></div>
          </div>
    </c:forEach>
  </div>