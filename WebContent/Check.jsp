<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4><a href="${pageContext.request.contextPath }/Catalog">返回</a></h4>
	<table border="1">
		<tr>
			<td>日期</td>
			<td>地点</td>
			<td>详细</td>
			<td>金额</td>
		</tr>
		<c:forEach items="${items}" var="item" >
			<tr>
				<td><c:out value="${item.date }" /></td>
				<td><c:out value="${item.location }" /></td>
				<td><c:out value="${item.detail }" /></td>
				<td><c:out value="${item.amount }" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>