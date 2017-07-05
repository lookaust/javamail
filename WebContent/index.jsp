<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/regist.do" method="post">
		<tr>
			<td><label for="username">账号</label></td>
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td><label for="password">密码</label></td>
			<td><input type="text" name="password" /></td>
		</tr>
		<tr>
			<td><label for="nickname">昵称</label></td>
			<td><input type="text" name="nickname" /></td>
		</tr>
		<tr>
			<td><label for="email">邮箱</label></td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="注册" /></td>
			<td><input type="reset" name="重写" /></td>
		</tr>
	</form>
</body>
</html>