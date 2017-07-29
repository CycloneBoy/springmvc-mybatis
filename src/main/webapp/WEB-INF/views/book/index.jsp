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
    <title>JSON测试页面</title>
    <script type="text/javascript" src="${ctx}/statics/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/json2.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            testRequestBody();
        });
        function testRequestBody() {

            var jsonData={
                "id":"1",
                "name":"Spring MVC企业级应用实战"
            }

            $.ajax(
            {
                dataType:"json",
                    type:"post",
                url:"${pageContext.request.contextPath}/json/testRequestBody",
                contentType:"application/json;charset=utf-8",//指定为json类型
                data:JSON.stringify(jsonData),
                success:function (data) {
                console.log(data);
                $("#id").html(data.id);
                $("#name").html(data.name);
                $("#author").html(data.author);
            },
                error:function(){
                    alter("数据发送失败");
                }
            });
        }
    </script>
</head>
<body>
    编号:<span id="id"></span><br>
    书名:<span id="name"></span><br>
    作者:<span id="author"></span><br>
</body>
</html>
