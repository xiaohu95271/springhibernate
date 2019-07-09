<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 2019/7/5
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <%
        String path = request.getContextPath();

        String basePath = request.getScheme()
                + "://" + request.getServerName()
                + ":"
                + request.getServerPort()
                + path
                + "/";
    %>
    <c:set var="path" value="<%=path %>"></c:set>
    <c:set var="basePath" value="<%=basePath %>"></c:set>
    <title>Title</title>
</head>
<body>
<h1>登陆页面</h1>
<form action="${path}/login" method="post" id="f1">
    账号：<input type="text" name="userCode"> <br>
    密码：<input type="password" name="password"> <br>
    <button type="button" onclick="login()">登陆</button>
</form>
<form action="${path}/addUser" method="post" id="f2">
    账号：<input type="text" name="userCode"><br>
    密码：<input type="password" name="password"> <br>
    <button type="button" onclick="addUser()">添加用户</button>
</form>
<script src="https://cdn.staticfile.org/jquery/2.0.0/jquery.min.js"></script>
<script>
   function login() {
       $.ajax({
           type: "POST",
           dataType: "json",
           url: '${path}/login',
           data: $('#f1').serialize(),
           success: function (data) {
               alert("success:" );
              if (data.code == 0){
                  document.location.href="${path}";
              }
           },
           error: function (data) {
               alert("error:" );
           }
       });
   }
   function addUser() {
       $.ajax({
           type: "POST",
           dataType: "json",
           url: '${path}/addUser',
           data: $('#f2').serialize(),
           success: function (data) {
               alert("success:" );
               document.location.reload();
           },
           error: function (data) {
               alert("error:");
           }
       });
   }
</script>
</body>
</html>
