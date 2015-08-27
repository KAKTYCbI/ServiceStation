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
     <form:form method = "post" action = "updateapplication" commandName = "application">
   
     <ul>
      <table>
      <tr>
        <td>
          <form:label path = "id">№:</form:label>
        </td>
        <td>
          XXXX
        </td>
      </tr>
       
       <tr>
        <td>
          Name:
        </td>
        <td>
          имя клиента
        </td>
      </tr>
       <tr>
        <td>
          Email:
        </td>
        <td>
          email
        </td>
      </tr>
       <tr>
        <td>
          Контакт:
        </td>
        <td>
          контак
        </td>
      </tr> 
       <tr>
        <td>
          Механик:
        </td>
        <td>
          имя механика
        </td>
      </tr>   
      <tr>
        <td>
          <form:label path = "status">Статус:</form:label>
        </td>
        <td>
          <form:select path="status">
          <option>Статус 1</option>
          <option>Статус 2</option>
  </form:select>
        </td>
      </tr> 
      <tr>
        <td>
          <form:label path = "sto">сто:</form:label>
        </td>
        <td>
          сто
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "services">Услуги:</form:label>
        </td>
        <td>
          список услуг
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "details">Детали:</form:label>
        </td>
        <td>
          <form:select multiple="multiple" path="details">
            <option>Деталь 1</option>
            <option>Деталь 2</option>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "dateOrder">Дата заявки:</form:label>
        </td>
        <td>
         <form:input path="dateOrder"/>
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "dateCompletion">Дата выполнение заявки:</form:label>
        </td>
        <td>
          <form:input path="dateCompletion"/>
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "price">стоимость:</form:label>
        </td>
        <td>
          хххххх
        </td>
      </tr>
      <tr>
        <td colspan="2"><input type="SUBMIT" value="updateapplication"></td>
      </tr>          
              </table>
            </ul>
            
            </form:form>
            </div>
          <div class = "reviewbottom"></div>
          </div>
    
  </div>