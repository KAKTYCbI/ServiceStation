<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />
<h1>История заявок на деталь</h1>
<a href="<c:url value='/mechanic/addapplicationdetail' />">Новая заявка на деталь</a>
</br>
 <div class="reviews">
    <c:forEach items="${applicationdetail}" var="applicationdetail" >
      <div class = "review">
         <div class = "reviewtop"></div>
            <div class = "reviewcenter">
            <ul>Название детали: ${applicationdetail.name }</br>
             Дата поступления детали: <fmt:formatDate value="${applicationdetail.dateDelivery }" pattern="dd-MM-yyyy" /></br>
             Статус:${applicationdetail.status.status }</br>
             
            </ul>
            </div>
          <div class = "reviewbottom"></div>
          </div>
     </c:forEach>
  </div>