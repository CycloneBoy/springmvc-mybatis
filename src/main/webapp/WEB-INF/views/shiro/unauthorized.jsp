<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <h3>用户登录失败页面</h3>
    欢迎用户:${username},认证未通过，或者权限不足<br>
    <a href="${ctx}/shiro/logout">退出登录</a>

</body>
</html>
