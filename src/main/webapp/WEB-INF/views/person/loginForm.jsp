<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
</head>
<body>
    <h3>用户登录页面</h3>
    <form:form method="post"  action="${ctx}/person/login" commandName="person">
        <table>
            <font color="red">${requestScope.message}</font>
            <tr>
                <td>登录名：</td>
                <td><form:input path="loginname"/></td>
                <td><form:errors path="loginname" cssStyle="color: red"/> </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password" cssStyle="color: red"/> </td>
            </tr>
            <tr>
                <td>操作</td>
                <td><form:button value="submit" name="登录"/> </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
