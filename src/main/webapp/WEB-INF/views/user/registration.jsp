<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>

</style>

<h3>Please sign out</h3>
<form:form method = "post" action = "registration" commandName = "client">
    <table>
      <tr>
        <td>
          <form:label path = "name">name</form:label>
        </td>
        <td>
          <form:input path="name"/>
        </td>
        <td>
        <form:errors path="name" cssClass="error"/>
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "login">login</form:label>
        </td>
        <td>
          <form:input path="login" />
        </td>
      </tr>
      <tr>
        <td>
          <form:label path = "password">password</form:label>
        </td>
        <td>
          <form:input path="password"/>
        </td>
        <td>
        <form:errors path="password" cssClass="error"/>
        </td>
      </tr>
            <tr>
        <td>
          <form:label path = "email">email</form:label>
        </td>
        <td>
          <form:input path="email"/>
        </td>
      <td>
        <form:errors path="email" cssClass="error"/>
        </td>
      </tr>
            <tr>
        <td>
          <form:label path = "contact">contact</form:label>
        </td>
        <td>
          <form:input path="contact"/>
        </td>
<td>
        <form:errors path="contact" cssClass="error"/>
        </td>
      </tr>

      <tr>
        <td colspan="2"><input type="SUBMIT" value="registration"></td>
      </tr>
    </table>
  </form:form>
