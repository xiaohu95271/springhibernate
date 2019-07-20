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
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="name" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>

    <%--<div class="layui-form-item">--%>
        <%--<label class="layui-form-label">选择框</label>--%>
        <%--<div class="layui-input-block">--%>
            <%--<select name="city" lay-verify="required">--%>
                <%--<option value=""></option>--%>
                <%--<option value="0">北京</option>--%>
                <%--<option value="1">上海</option>--%>
                <%--<option value="2">广州</option>--%>
                <%--<option value="3">深圳</option>--%>
                <%--<option value="4">杭州</option>--%>
            <%--</select>--%>
        <%--</div>--%>
    <%--</div>--%>
    <div class="layui-form-item">
        <label class="layui-form-label">角色</label>
        <div class="layui-input-block">
            <c:forEach items="${roles}" var="role">
                <input type="checkbox" name="${role.nameEn}" value="${role.nameEn}" title="${role.nameZh}">
            </c:forEach>
        </div>
    </div>
    <div class="layui-inline">
        <div class="layui-inline">
            <div class="layui-form-item">
                <label class="layui-form-label">用户头像</label>
                <div class="layui-input-inline">
                    <button type="button" class="layui-btn" id="test1">
                        <i class="layui-icon">&#xe67c;</i>上传图片
                    </button>
                </div>

            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">单选框</label>
                <div class="layui-input-block">
                    <input type="radio" name="sex" value="男" title="男">
                    <input type="radio" name="sex" value="女" title="女" checked>
                </div>
            </div>
            <%--<div class="layui-form-item layui-form-text">--%>
            <%--<label class="layui-form-label">文本域</label>--%>
            <%--<div class="layui-input-block">--%>
            <%--<textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>--%>
            <%--</div>--%>
            <%--</div>--%>
            <div class="layui-form-item">
                <label class="layui-form-label">禁用</label>
                <div class="layui-input-block">
                    <input type="checkbox" name="switch" lay-skin="switch" lay-text="启用|禁用">
                </div>
            </div>
        </div>
        <div class="layui-inline pull-right" id="imgShow">

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
        version: '1560414887155' //为了更新 js 缓存，可忽略
    });
    layui.use('upload', function(){
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,acceptMime: 'image/*'//（只显示图片文件）
            ,url: '${path}/file/upload/upload' //上传接口
            ,drag:true
            ,done: function(res){
                //上传完毕回调
                $("#imgShow").html("<img src=\"http://"+res.filePath+"\" id=\"headImg\" width=\"100px\" height=\"100px\">")
                layer.msg("上传成功！",{icon:1})
            }
            ,error: function(){
                //请求异常回调
                layer.msg("上传失败！",{icon:5})
            }
        });
    });
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.alert(JSON.stringify(data.field));
            return false;
        });
    });

</script>
</body>
</html>
