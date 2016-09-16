<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/Catalog">返回</a><br>
	<form action="${pageContext.request.contextPath }/AddItem" method="post">
		日期：<input type="text" name="date"/> (格式：yyyyMMdd)<br>
		地点：<input type="text" name="location"/><br>
		详细：<input type="text" name="detail"/><br>
		金额：<input type="text" name="amount"/><br>
		<input type="submit" value="提交"/>
		<input type="reset" value="重置"/><br>
		<h3>${result }</h3>
	</form>
</body>
</html>