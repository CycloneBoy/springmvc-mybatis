<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
</head>
<body>
<h3>用户登录页面</h3>
<form action="${ctx}/shiro/login" method="post">
    username:<input type="text" name="username"/><<br>
    password:<input type="password" name="password"/><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
