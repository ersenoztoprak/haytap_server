<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Sipariþ Tarihi</th>
				<th>Sipariþ Detaylarý</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="order" items="${orders}">
				<tr>
					<td>${order.createdDate}</td>
					<td><a href="/order/${order.id}">Detaylar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<a href="/drinks">Geri dön</a>
</body>
</html>