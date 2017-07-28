<%--
  Created by IntelliJ IDEA.
  User: CycloneBoy
  Date: 2017/7/28
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>测试JSR 303</title>
</head>
<body>
    <h3>测试页面</h3>
    登录名:${requestScope.person.loginname}<br>
    密码:${requestScope.person.password}<br>
    用户名:${requestScope.person.username}<br>
    性别:${requestScope.person.sex}<br>
    年龄:${requestScope.person.age}<br>
    邮箱:${requestScope.person.email}<br>
    生日:<fmt:formatDate value="${requestScope.person.birthday}"
            pattern="yyyy年MM月dd日 hh时MM分ss秒"/><br>
    电话:${requestScope.person.phone}<br>
    用户头像:
    <a href="${ctx}/person/download?filename=${requestScope.person.image.originalFilename}">
        ${requestScope.person.image.originalFilename}
    </a><br>
    <td>商品图片</td>
    <td><c:if test="${requestScope.person.pic !=null}">
        <img src="/file/${requestScope.person.pic}" width=100 height=100 /><br />
    </c:if>
    </td>
</body>
</html>
