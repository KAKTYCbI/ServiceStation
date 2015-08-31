<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />

<h1>Список механиков</h1>
</br>
 <div class="reviews">
<c:forEach items="${mechanic}" var="mechanic" >
      <div class = "review">
         <div class = "reviewtop"></div>
          
            <div class = "reviewcenter">
            <div class="rating">
                 <ul>${mechanic.rating }</ul>
               </div>
            <ul>Имя: ${mechanic.name }&nbsp;&nbsp;
            СТО:${mechanic.sto.name }&nbsp;&nbsp;
             <a href="<c:url value='/director/updatemechanic/${mechanic.userId}' />"/>Подробости</a>
            </ul></br>
            </div>
          <div class = "reviewbottom"></div>
          </div>
</c:forEach>
  
  </div>