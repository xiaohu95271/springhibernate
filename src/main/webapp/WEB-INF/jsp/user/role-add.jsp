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
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>用户首页-列表</title>
    <%@include file="/WEB-INF/jsp/common/import.jsp" %>

    <link rel="stylesheet" href="${path}/component/easyui/easyui.css"  />
    <link rel="stylesheet" href="${path}/component/easyui/combo.css"  />
    <link rel="stylesheet" href="${path}/component/easyui/tree.css"  />

    <script type="text/javascript" src="${path}/component/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${path}/component/easyui/jquery.combo.js"></script>
    <script type="text/javascript" src="${path}/component/easyui/jquery.tree.js"></script>
    <style>
        body {
            margin: 10px;
        }

        .demo-carousel {
            height: 200px;
            line-height: 200px;
            text-align: center;
        }
    </style>
</head>
<body>
<form class="layui-form" action="">
<div class="layui-form-item">
    <div class="layui-form-item">
        <label class="layui-form-label">名称</label>
        <div class="layui-input-block">
            <input type="text" name="name_zh" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">标识</label>
        <div class="layui-input-block">
            <input type="text" name="name_en" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色菜单</label>
        <div class="layui-input-block">
            <input type="text" name="name_en" required id="treeSelect"  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>

</form>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<blockquote class="layui-elem-quote layui-quote-nm layui-hide" id="footer">layui {{ layui.v }} 提供强力驱动</blockquote>


<script>
    layui.config({
        version: '1560414887156' //为了更新 js 缓存，可忽略
    });
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
    $('#treeSelect').combotree({
        url: '${path}/menu/menuData',
        required: true,
        multiple: true,
        onChange :function(val,result){
            console.log(val)
            console.log(result)
            $("#treeSelect").val("402881866be8e82b016be9054dac0007");

        },
    });

</script>
</body>
</html>
