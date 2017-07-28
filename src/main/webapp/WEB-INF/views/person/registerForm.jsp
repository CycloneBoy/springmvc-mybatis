<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSR 303</title>
</head>
<body>
    <h3>用户注册页面</h3>
    <form:form method="post" enctype="multipart/form-data" action="${ctx}/person/register" commandName="person">
        <table>
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
                <td>用户名：</td>
                <td><form:input path="username"/></td>
                <td><form:errors path="username" cssStyle="color: red"/> </td>
            </tr>
            <tr>
                <td>性别：</td>
                <td>
                    <form:radiobutton path="sex" value="男"/> 男&nbsp;
                    <form:radiobutton path="sex" value="女"/> 女&nbsp;
                    <form:radiobutton path="sex" value="保密"/> 保密&nbsp;
                </td>
                <td><form:errors path="sex" cssStyle="color: red"/> </td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td><form:input path="age"/></td>
                <td><form:errors path="age" cssStyle="color: red"/> </td>
            </tr>
            <tr>
                <td>邮箱：</td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email" cssStyle="color: red"/> </td>
            </tr>
            <tr>
                <td>生日：</td>
                <td><form:input path="birthday"/></td>
                <td><form:errors path="birthday" cssStyle="color: red"/> </td>
            </tr>
            <tr>
                <td>电话：</td>
                <td><form:input path="phone"/></td>
                <td><form:errors path="phone" cssStyle="color: red"/> </td>
            </tr>
            <tr>
                <td>请上传图像：</td>
                <td><input type="file" name="image"></td>
            </tr>
            <tr>
                <td>商品图片</td>
                <td><c:if test="${pic !=null}">
                    <img src="/file/${pic}" width=100 height=100 /><br />
                </c:if>
                    <input type="file" name="person_pic"/>
                </td>
            </tr>
            <tr>
                <td>操作</td>
                <td><form:button value="submit" name="提交"/> </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
