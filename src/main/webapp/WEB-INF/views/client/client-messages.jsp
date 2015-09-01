<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />

<h1>Сообщения</h1>
</br>
 <div class="reviews">
 <c:forEach items="${message}" var="message" >
      <div class = "review">
         <div class = "reviewtop"></div>
            <div class = "reviewcenter"><ul>
                 От кого:${message.mechanic.name }</br>
                 Кому:${message.client.name }</br>
                 ${message.text }</br> </ul>
            </div>
          <div class = "reviewbottom"></div>
          </div>
  </c:forEach>
  </div>
  