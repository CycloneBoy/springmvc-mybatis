<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>更新商品列表</title>
</head>
<body>

<form:form  action="${ctx}/items/editItems" method="post" commandName="itemsCustom" >
    <table width="100%" border=1>
        <tr>
            <td><form:hidden path="id"/></td>
            <td><form:hidden path="createtime"/></td>
        </tr>
        <tr>
            <td>商品名称:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>商品价格:</td>
            <td><form:input path="price"/></td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td><form:input path="detail"/></td>
        </tr>
        <tr>
            <td><form:hidden path="pic"/></td>
        </tr>
    </table>
    提交：
    <table width="100%" border=1>
        <tr>
            <td><input type="submit" value="提交" /></td>
        </tr>
    </table>
</form:form>
</body>

</html>
