<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />
<h1>Укажите настройки отчета:</h1>
</br>
 <div class="reviews">

      <div class = "review">
         <div class = "reviewtop"></div>
            <div class = "reviewcenter">
     <form:form method = "post" action = "getreport" commandName = "reportinfo">
   
     <ul>
      <table>
     <b>О ком:</b>
				<form:radiobutton path="whom" value="all" /> All
	            <form:radiobutton path="whom" value="sto" /> Sto</br></br>
	              <form:label path = "sto">СТО</form:label>
        
                     <form:select path="sto">
                       <c:forEach items="${stos}" var="stos" >
                        <option path ="sto">${stos.name}</option>	
                       </c:forEach>
                     </form:select>
	           
      <tr>
        <td>
          <form:label path = "dateStart"><b>С:</b></form:label>
        </td>
        <td>
        <form:input type="date" path="dateStart" />
        </td>
         <td><form:errors path="dateStart" cssClass="error"/></td>
      </tr>
      <tr>
        <td>
          <form:label path = "dateFinish"><b>До:</b></form:label>
        </td>
        <td>
          <form:input type="date" path="dateFinish" />
        </td>
         <td><form:errors path="dateFinish" cssClass="error"/></td>
      </tr>
      
      <tr>
        <td colspan="2"><input type="SUBMIT" value="report"></td>
      </tr>          
              </table>
            </ul>
            
            </form:form>
            </div>
          <div class = "reviewbottom"></div>
          </div>
    
  </div>