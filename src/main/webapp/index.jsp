<%--
  Created by IntelliJ IDEA.
  User: CycloneBoy
  Date: 2017/7/27
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>商品订单测试主页</title>
  </head>
  <body>
        <h1>商品订单测试主页</h1>
        <a href="${ctx}/items/queryItems">查询所有</a><br/>
        <a href="${ctx}/person/register">注册页面(person)</a><br/>
        <a href="${ctx}/json/index">ajax 请求json 测试</a><br/>
        <a href="${ctx}/json/testjson">ajax 发送post,返回json格式数据测试</a><br/>
        <a href="${ctx}/json/main">拦截器测试主页</a><br/><br/>

        <a href="${ctx}/shiro/admin">admin主页</a><br/>
  </body>
</html>
