<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
</head>
<body>
<form
        action="${pageContext.request.contextPath }/items/queryItems"
        method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td><input type="submit" value="查询" /></td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>选择</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemsList }" var="item">
            <tr>
                <td><input type="checkbox" name="items_id" value="${item.id}"/></td>
                <td>${item.name }</td>
                <td>${item.price }</td>
                <td><fmt:formatDate value="${item.createtime}"
                                    pattern="yyyy-MM-dd HH:mm:ss" /></td>
                <td>${item.detail }</td>

                <td><a href="${ctx}/items/editItems?id=${item.id}">修改</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>

</html>
