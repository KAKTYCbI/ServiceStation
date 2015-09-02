<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css"/>" />
<h1>Отчет по всем СТО</h1>

</br>
 <div class="reviews">

      <div class = "review">
         <div class = "reviewtop"></div>
            <div class = "reviewcenter">
             <ul>Выполнено заявок на сумму:${report.applicationPrice } </br>
             Выдано зарплаты:${report.salaryPrice }</br>
             Выплачено аренды:${report.rentPrice }</br>
             Закуплено деталей на сумму:${report.detailPrice }</br>
             Итого затрат:${report.expenses }</br>
             Итого прибыль:${report.profit }
            
            </ul>
            </div>
          <div class = "reviewbottom"></div>
          </div>

  </div>