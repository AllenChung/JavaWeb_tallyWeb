<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录页面</h1>
	<form action="${pageContext.request.contextPath }/Login" method="post">
		user name: <input type="text" name="userName"/>${errorUserName }<br/>
		password: <input type="password" name="password"/>${errorPassword }<br/>
		<input type="submit" value="login"/>
		<input type="reset" value="reset"/><br>
	</form>
	<a href="${pageContext.request.contextPath }/Register.jsp">先注册</a>
</body>
</html>