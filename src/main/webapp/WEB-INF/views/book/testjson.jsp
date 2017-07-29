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
    <title>JSON测试页面：返回JSON格式的数据</title>
    <script type="text/javascript" src="${ctx}/statics/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/json2.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            testRequestBody();
        });
        function testRequestBody() {
            $.post("${ctx}/json/testRequestBodyTwo",null,
            function (data) {
                $.each(data,function () {
                    var tr = $("<tr align='center'/>");
                    $("<td/>").html(this.id).appendTo(tr);
                    $("<td/>").html(this.name).appendTo(tr);
                    $("<td/>").html(this.author).appendTo(tr);
                    $("#booktable").appendTo(tr);
                })
            },"json");
        }
    </script>
</head>
<body>
<table id="booktable" border="1" style="border-collapse: collapse;">
    <tr align="center">
        <th>编号</th>
        <th>书名</th>
        <th>作者</th>
    </tr>
</table>

</body>
</html>
