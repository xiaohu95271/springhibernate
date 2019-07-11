<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 2019/7/10
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>菜单管理列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<%--    <link rel="stylesheet" href="layui/css/layui.css" media="all">--%>
    <%@include file="/WEB-INF/jsp/common/import.jsp" %>
</head>
        <body>
                <div id="test1"></div>
                <script>
                        layui.use('tree', function(){
                        var tree = layui.tree;

                        //渲染
                        var inst1 = tree.render({
                        elem: '#test1' //绑定元素
                                ,data: [{
                                        title: '江西' //一级菜单
                                        ,children: [{
                                        title: '南昌' //二级菜单
                                        ,children: [{
                                        title: '高新区' //三级菜单
                                        //…… //以此类推，可无限层级
                                        }]
                                        }]
                                },{
                                        title: '陕西' //一级菜单
                                        ,children: [{
                                        title: '西安' //二级菜单
                                        }]
                                        }]
                                });
                        });
                </script>
        </body>
</html>



