<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<h1>注册页面</h1>
	<form action="${pageContext.request.contextPath }/Register" method="post">
	<h3>${errors["errorName"] }</h3><br>
		user name: <input type="text" name="userName"/><br>
		password: <input type="password" name="password"/><br>
		<input type="submit" value="regist"/>
		<input type="reset" value="reset"/><br>
	</form>
	<a href="${pageContext.request.contextPath }/Index.jsp">直接登录</a>
</body>
</html>