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
<form:form method = "post" action = "addapplication" commandName = "client">
    <table>
      <tr>
        <td>
          <form:label path = "name">Имя</form:label>
        </td>
        <td>
          <form:input path="name"/>
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "login">Email</form:label>
        </td>
        <td>
          <form:input path="login" />
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "password">Контакт</form:label>
        </td>
        <td>
          <form:input path="password"/>
        </td>
      </tr>
            <tr>
        <td>
          <form:label path = "email">СТО</form:label>
        </td>
        <td>
          <form:select path="email">
          <option>СТО 1</option>
          <option>СТО 2</option>
  </form:select>
        </td>
      
      </tr>
            <tr>
        <td>
          <form:label path = "contact">Услуга</form:label>
        </td>
        <td>
          <form:select multiple="multiple" path="contact">
          <option>Услуга 1</option>
          <option>Услуна 2</option>
  </form:select>
        </td>

      </tr>

      <tr>
        <td colspan="2"><input type="SUBMIT" value="addapplication"></td>
      </tr>
    </table>
</form:form>
            </div>
          <div class = "reviewbottom"></div>
          </div>
  </div>