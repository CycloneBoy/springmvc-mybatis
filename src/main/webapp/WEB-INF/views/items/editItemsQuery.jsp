<%--
  Created by IntelliJ IDEA.
  User: CycloneBoy
  Date: 2017/7/27
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>批量更新商品</title>
</head>
<body>
    <form:form action="${ctx}/items/editItemsQuery" method="post"
               commandName="itemsList">
        <table>
            <tr>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>生产日期</td>
                <td>商品描述</td>
                <td>照片</td>
            </tr>
            <c:forEach items="${itemsList}" var="item" varStatus="status" >
            <tr>
                <td><input name="itemList[${status.index}].id" value="${item.id}" type="hidden"></td>
                <td><input name="itemList[${status.index}].name" value="${item.name}"></td>
                <td><input name="itemList[${status.index}].price" value="${item.price}"></td>
                <td><input name="itemList[${status.index}].createtime" value="${item.createtime}"></td>
                <td><input name="itemList[${status.index}].detail" value="${item.detail}"></td>
                <td><input name="itemList[${status.index}].pic" value="${item.pic}"></td>
            </tr>
            </c:forEach>

            <table width="100%" border=1>
                <tr>
                    <td><input type="submit" value="提交" /></td>
                </tr>
            </table>
        </table>
    </form:form>
</body>
</html>
