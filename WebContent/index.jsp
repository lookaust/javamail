<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//Dli HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dli">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="RegistServlet" method="post">
		<ul>
			<li><label for="username">账号</label><input type="text" name="username" /></li>
			<li><label for="password">密码</label><input type="text" name="password" /></li>
			<li><label for="nickname">昵称</label><input type="text" name="nickname" /></li>
			<li><label for="email">邮箱</label><input type="text" name="email" /></li>
			<li><input type="submit" value="注册" /></li>
			<li><input type="reset" name="重写" /></li>
		</ul>
	</form>
</body>
</html>