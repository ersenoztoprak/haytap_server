<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
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
    
    function addAddOn(itemId, addOnId) {
    	post("/item/" + itemId + "/add/" +addOnId);
    }
    
    function removeAddOn(itemId, itemAddOnId) {
    	post("/" + itemId + "/itemAddOn/" + itemAddOnId + "/delete/");
    }
    
    </script>

</head>
<body>


	<c:if test="${not empty itemAddOns}">
		<table border="1" align="center" style="width: 50%">
			<thead>
				<tr>
					<td colspan="3">Ürün Detaylarý</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="itemAddOn" items="${itemAddOns}">
					<tr>
						<td>${itemAddOn.addon.name}</td>
						<td>${itemAddOn.addon.price}</td>

						<td>
							<button onclick="removeAddOn(${itemId}, ${itemAddOn.id})">Çýkar</button>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>

	<table border="1" align="center" style="width: 50%">
		<thead>
			<tr>
				<td colspan="3">Ekleyebileceðiniz Yan Ürünler</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="addOn" items="${addOns}">
				<tr>
					<td>${addOn.name}</td>
					<td>${addOn.price}</td>

					<td>
						<button onclick="addAddOn(${itemId}, ${addOn.id})">Ekle</button>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="/basket">Sepete Dön</a>

</body>
</html>