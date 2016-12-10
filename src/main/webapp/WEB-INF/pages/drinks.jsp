<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Kahveci Mehmet Efendi</title>

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

	<c:if test="${not empty msg}">
		<div>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<table border="1" align="center" style="width: 50%">
		<thead>
			<tr>
				<th>Ýçecek</th>
				<th>Fiyat</th>
				<th>Sepete Ekle</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="drink" items="${drinks}">
				<tr>
					<td>${drink.name}</td>
					<td>${drink.price}</td>
					<td>
						<button onclick="addItem(${drink.id})">Sepete Ekle</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/basket">Sepeti Görüntüle</a><br>
	<a href="/order">Sipariþlerim</a>
	
</body>
</html>