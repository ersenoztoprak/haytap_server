<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/order">Geri dön</a>
	
</body>
</html>