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
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%--<link rel="stylesheet" href="layui/css/layui.css" media="all">--%>
    <%@include file="/WEB-INF/jsp/common/import.jsp" %>
</head>
<body>

    <div style="padding: 20px;">
        <form class="layui-form" id="formData">
            <div class="layui-form-item">
                <label class="layui-form-label">父级名称</label>
                <div class="layui-input-block">
                    <input type="text" name="pName" value="${name}"  readonly autocomplete="off" class="layui-input layui-disabled">
                    <input type="hidden" name="pid" value="${menu.pid}" >
                    <input type="hidden" name="id" value="${menu.id}" >
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜单名称</label>
                <div class="layui-input-block">
                    <input type="text" name="name" required lay-verify="required" placeholder="请输入菜单名称"  value="${menu.name}"
    autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜单链接</label>
                <div class="layui-input-block">
                    <input type="text" name="href" placeholder="请输入菜单链接"  value="${menu.href}"
    autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">图标路径</label>
                <div class="layui-input-block">
                    <input type="text" name="icon" placeholder="请输入图标路径"  value="${menu.icon}"
    autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">排序</label>
                <div class="layui-input-block">
                    <input type="number" name="orderNumber" placeholder="请输入排序降序排序"  value="${menu.orderNumber}"
    autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <input type="text" name="remark"  placeholder="请输入备注" value="${menu.remark}" autocomplete="off" class="layui-input">
                </div>
            </div>
<%--            <div class="layui-form-item">--%>
<%--                <label class="layui-form-label">图标路径</label>--%>
<%--                <div class="layui-input-inline">--%>
<%--                    <input type="password" name="password" required lay-verify="required" placeholder="请输入密码"--%>
<%--                           autocomplete="off" class="layui-input">--%>
<%--                </div>--%>
<%--                <div class="layui-form-mid layui-word-aux">辅助文字</div>--%>
<%--            </div>--%>
<%--            <div class="layui-form-item">--%>
<%--                <label class="layui-form-label">选择框</label>--%>
<%--                <div class="layui-input-block">--%>
<%--                    <select name="city" lay-verify="required">--%>
<%--                        <option value=""></option>--%>
<%--                        <option value="0">北京</option>--%>
<%--                        <option value="1">上海</option>--%>
<%--                        <option value="2">广州</option>--%>
<%--                        <option value="3">深圳</option>--%>
<%--                        <option value="4">杭州</option>--%>
<%--                    </select>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="layui-form-item">--%>
<%--                <label class="layui-form-label">复选框</label>--%>
<%--                <div class="layui-input-block">--%>
<%--                    <input type="checkbox" name="like[write]" title="写作">--%>
<%--                    <input type="checkbox" name="like[read]" title="阅读" checked>--%>
<%--                    <input type="checkbox" name="like[dai]" title="发呆">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="layui-form-item">--%>
<%--                <label class="layui-form-label">开关</label>--%>
<%--                <div class="layui-input-block">--%>
<%--                    <input type="checkbox" name="switch" lay-skin="switch">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="layui-form-item">--%>
<%--                <label class="layui-form-label">单选框</label>--%>
<%--                <div class="layui-input-block">--%>
<%--                    <input type="radio" name="sex" value="男" title="男">--%>
<%--                    <input type="radio" name="sex" value="女" title="女" checked>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="layui-form-item layui-form-text">--%>
<%--                <label class="layui-form-label">文本域</label>--%>
<%--                <div class="layui-input-block">--%>
<%--                    <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>--%>
<%--                </div>--%>
<%--            </div>--%>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
<script>
        layui.use('form', function () {
        var form = layui.form;
            form.render();
        });


    $("#formData").submit(function () {
       $(this).ajaxSubmit(ajaxFormOption);
        return true;
    });

    var ajaxFormOption = {
        type: "post",  //提交方式
        dataType: "json", //数据类型
        data: $("#formData").serialize(),//自定义数据参数，视情况添加
        url: "${path}/menu/add", //请求url
        success: function (data) { //提交成功的回调函数
            layer.msg('添加成功', {icon: 6,time: 5000});
            window.parent.layer.closeAll()
        }
    };
 </script>
</body>
</html>



