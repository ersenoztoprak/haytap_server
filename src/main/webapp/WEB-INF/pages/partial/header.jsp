<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello world page</title>

<script type="text/javascript">
    
    function post(path, params, method) {
    	method = method || "post"; 

    	var form = document.createElement("form");
    	form.setAttribute("method", method);
    	form.setAttribute("action", path);

    	for ( var key in params) {
    		if (params.hasOwnProperty(key)) {
    			var hiddenField = document.createElement("input");
    			hiddenField.setAttribute("type", "hidden");
    			hiddenField.setAttribute("name", key);
    			hiddenField.setAttribute("value", params[key]);

    			form.appendChild(hiddenField);
    		}
    	}

    	document.body.appendChild(form);
    	form.submit();
    }
    
    function addItem(id) {
    	post("/" + id + "/basket");
    }
    
    </script>

</head>
<body>