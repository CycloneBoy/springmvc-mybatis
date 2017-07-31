<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <h3>用户登录成功页面</h3>
    欢迎用户:${username}<br>
    <a href="${ctx}/shiro/admin">admin页面</a><br/>
    <a href="${ctx}/shiro/student">student页面</a><br/>
    <a href="${ctx}/shiro/teacher">teacher页面</a><br/>
    <a href="${ctx}/shiro/logout">退出登录</a>

</body>
</html>
