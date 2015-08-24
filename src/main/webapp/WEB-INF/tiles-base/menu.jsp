<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/menu.css"/>" />


<div class="vert_menu">
<h1>Меню</h1>
<div class="verch"></div>
<div class="center">
<ul>
<security:authorize access="hasRole('ROLE_DIRECTOR')" >
<li><a href="">Список заявок</a></li>
<li><a href="">Заявки на деталь</a></li>
<li><a href="">Добавление деталей</a></li>
<li><a href="">Добавление механиков</a></li>
<li><a href="">Аренда</a></li>
<li><a href="">Отчет</a></li>
<li><a href="">Список механиков</a></li>
<li><a href="">Список СТО</a></li>
<li><a href="">Добавление услуги</a></li>
 </security:authorize> 
 <security:authorize access="hasRole('ROLE_MECHANIC')" >
<li><a href="">Список заявок</a></li>
<li><a href="">Заявки на детали</a></li>
<li><a href="">Отзывы обо мне</a></li>
 </security:authorize> 
 <security:authorize access="hasRole('ROLE_CLIENT')" >
<li><a href="">Оформить заявку</a></li>
<li><a href="">Уведомление</a></li>
<li><a href="">История заявок</a></li>
<li><a href="">Список СТО</a></li>
 </security:authorize> 
</ul>
</div>
<div class="niz"></div>
</div>
