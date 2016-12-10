<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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
    
    function removeItem(itemId) {
    	post("/item/" + itemId + "/delete/");
    }
    
    function order() {
    	post("/order")
    }
    
    </script>

</head>
<body>

	<table border="1" align="center" style="width: 50%">
		<thead>
			<tr>
				<th>Ýçecek</th>
				<th>Yan Ürünler</th>
				<th>Fiyat</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items}">
				<tr>
					<td>${item.drinkName}</td>
					<td>
						<ul>
							<c:forEach var="addon" items="${item.addOns}">
								<li>${addon.name}</li>
							</c:forEach>
						</ul>
						
					</td>
					<td>${item.price}</td>
				
				    <td><a href="/item/${item.id}">Detaylar</a></td>

					<td>
						<button onclick="removeItem(${item.id})">Çýkar</button>
					</td>
				
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td>
					<button onclick="order()">Sipariþi Onayla</button>
				</td>
			</tr>
		</tfoot>
	</table>
	
	<a href="/drinks">Geri dön</a>
	
</body>
</html>