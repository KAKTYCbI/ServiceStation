<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/client/info" var="clientInfoUrl"/>
<c:url value="/client/delete" var="clientDeleteUrl"/> 

<script type="text/javascript">

function clientInfo(clientId) {
	
	var json = { id: clientId };
	$.ajax({
        url: "${clientInfoUrl}",
        data: JSON.stringify(json),
        type: "POST",
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        success: function(obj) {
        	$('#result').html("");
    		//var obj = JSON.parse(response);
    		$('#result').html("Name: " + obj.name +"</br>SSN: " + obj.ssn);
        },
        error: function(){
            alert('failure');
        }
    });
}

function clientDelete(clientId) {
	
	var json = { id: clientId };
	$.ajax({
        url: "${clientDeleteUrl}/" + clientId + "/ajax",
        type: "POST",
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        success: function(obj) {
        	if (obj) {
        		var tr = $("#client"+clientId);
                tr.css("background-color","#FF3700");

                tr.fadeOut(400, function(){
                    tr.remove();
                });
                
        		$('#result').html("Deleted client: " + obj.name);
        	} else {
        		$('#result').html("Error");
        	}
    		
        },
        error: function(){
            alert('failure');
        }
    });
}
</script>

<h1>Clients: </h1>
 
<a href="<c:url value="/client/new" />">New Client</a> 

<br/><br/>

<table id="clientsTable" border="1" cellpadding="10" cellspacing="0" class="table table-striped table-bordered">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>SSN</th>
		<th></th>
	</tr>

	<c:forEach items="${clients}" var="client" >
		<c:url value="/client/${client.id}" var="viewClientUrl" />
		
		<tr id="client${client.id}">
		    <td>${client.id}</td>		    
		    <td><a href="${viewClientUrl}">${client.name}</a></td> 
		    
		    <td>${client.ssn}  &nbsp;  &nbsp;</td>
		    
		    <td>
		    	<a href="<c:url value="/client/edit/${client.id}" />"> Edit </a> &nbsp;
		    	<a href="<c:url value="/client/delete/${client.id}" />"> Delete </a>
		   	</td>
		   	<td>
		    	<span onclick="clientInfo(${client.id})">Client Info (ajax)</span> <br/>
		    	<span onclick="clientDelete(${client.id})">Client Delete (ajax)</span> 
		   	</td>
	   	</tr>
	</c:forEach>
</table>

<div id="result"></div>
 
