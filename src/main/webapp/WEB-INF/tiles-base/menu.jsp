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
<li><a href="<c:url value='/home' />">Главная</a></li>
<li><a href="<c:url value='/director/getapplication' />">Список заявок</a></li>
<li><a href="<c:url value='/director/getapplicationdetail' />">Заявки на деталь</a></li>
<li><a href="<c:url value='/director/adddetail' />">Добавление деталей</a></li>
<li><a href="<c:url value='/director/addmechanic' />">Добавление механиков</a></li>
<li><a href="<c:url value='/director/addrent' />">Аренда</a></li>
<li><a href="<c:url value='/director/getreport' />">Отчет</a></li>
<li><a href="<c:url value='/director/getmechanics' />">Список механиков</a></li>
<li><a href="<c:url value='/director/getsto' />">Список СТО</a></li>
<li><a href="<c:url value='/director/addservice' />">Добавление услуги</a></li>
 </security:authorize> 
 <security:authorize access="hasRole('ROLE_MECHANIC')" >
 <li><a href="<c:url value='/home' />">Главная</a></li>
<li><a href="<c:url value='/mechanic/getapplication' />">Список заявок</a></li>
<li><a href="<c:url value='/mechanic/getapplicationdetail' />">Заявки на детали</a></li>
<li><a href="<c:url value='/mechanic/getreviewbymechanic' />">Отзывы обо мне</a></li>
 </security:authorize> 
 <security:authorize access="hasRole('ROLE_CLIENT')" >
 <li><a href="<c:url value='/home' />">Главная</a></li>
<li><a href="<c:url value='/client/addapplication' />">Оформить заявку</a></li>
<li><a href="<c:url value='/client/messages' /> ">Уведомление</a></li>
<li><a href="<c:url value='/client/getapplication' />">История заявок</a></li>
<li><a href="<c:url value='/client/getsto' />">Список СТО</a></li>
 </security:authorize> 
</ul>
</div>
<div class="niz"></div>
</div>
