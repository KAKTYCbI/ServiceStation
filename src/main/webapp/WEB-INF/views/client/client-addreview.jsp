<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css" 	href="<c:url value="/resources/css/home.css"/>" />
<h1>Оставление отзыва:</h1>
<div class="reviews">
	<div class="review">
		<div class="reviewtop"></div>
		<div class="reviewcenter">
			<form:form method="post" action="addreview" commandName="review">
				<form:radiobutton path="whom" value="sto" /> STO
	            <form:radiobutton path="whom" value="mechanic" /> Mechanic</br></br>
	            <form:radiobutton path="rating" value="1" /> 1
	            <form:radiobutton path="rating" value="2" /> 2
	            <form:radiobutton path="rating" value="3" /> 3
	            <form:radiobutton path="rating" value="4" /> 4
	            <form:radiobutton path="rating" value="5" /> 5</br></br>
	        
	          </br> 
              <input type="SUBMIT" value="addreview">
      
			</form:form>

			<div class="reviewbottom"></div>

		</div>
	</div>
</div>