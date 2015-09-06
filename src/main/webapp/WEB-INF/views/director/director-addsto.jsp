<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />

<h1>Дабавление сто</h1>
</br>
 <div class="reviews">
      <div class = "review">
         <div class = "reviewtop"></div>
            <div class = "reviewcenter">
            <ul>
<form:form method = "post" action = "addsto" commandName = "sto">
    <table>
      
      <tr>
        <td>
          <form:label path = "name">Название сто:</form:label>
        </td>
        <td>
          <form:input path="name" />
        </td>
        <td><form:errors path="name" cssClass="error"/></td>
      </tr>
      <tr>
        <td>
          <form:label path = "price">Стоимость Аренды:</form:label>
        </td>
        <td>
          <form:input path="price"/>
        </td>
        <td><form:errors path="price" cssClass="error"/></td>
      </tr>
      
      <tr>
        <td colspan="2"><input type="SUBMIT" value="Добавить СТО"></td>
      </tr>
    </table>
  </form:form></ul>
  <div class = "reviewbottom"></div>
          </div>
  </div>