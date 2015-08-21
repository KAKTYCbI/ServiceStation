<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ taglib prefix="f" uri="http://example.jstl.com/functions"%>

<h1>Client Details: ${client.name}</h1>

ID:   ${client.id} <br/></br>
Name: ${client.name} <br/></br>
SSN (full):  ${client.ssn} <br/></br>
SSN (secured):  ***-***${fn:substring(client.ssn, 7, -1)} <br/></br>
SSN (secured custom):  ${f:replaceAll(client.ssn, '([0-9]{3})', '***')} <br/></br>

Is Active: ${client.active} <br/></br>
Country: ${client.country.name} (${client.country.code}) <br/></br>
Balance: ${client.balance} <br/></br>
Notes: ${client.notes} <br/></br>

<br/></br>
<br/></br>

