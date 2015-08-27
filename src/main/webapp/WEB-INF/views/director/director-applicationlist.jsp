<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />
<h1>История заявок</h1>
</br>
 <div class="reviews">
      <div class = "review">
         <div class = "reviewtop"></div>
            <div class = "reviewcenter">
            <ul>№: ХХХХ</br>
             От кого: "Name"</br>
             Кому название СТО</br>
             Дата заявки:XX.XX.XX</br>
             <a href="<c:url value='/director/updateapplication' />">Подробости</a>
            </ul>
            </div>
          <div class = "reviewbottom"></div>
          </div>
  </div>