<%--
  Created by IntelliJ IDEA.
  User: CycloneBoy
  Date: 2017/7/29
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Book 测试首页</title>
    <script type="text/javascript" src="${ctx}/statics/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/json2.js"></script>

</head>
<body>
    <h3>欢迎${sessionScope.user.username}</h3>
    <table  border="1" >
        <tr>
            <th>ID</th>
            <th>书名</th>
            <th>作者</th>
        </tr>
        <c:forEach items="${requestScope.bookList}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
