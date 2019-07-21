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
    <title>用户管理-详情</title>
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

<form class="layui-form" action="" id="dataForm">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="name" required disabled  value="${user.name}" lay-verify="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            <input type="hidden" name="id" required  value="${user.id}" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机</label>
        <div class="layui-input-inline">
            <input type="text" name="mobile" required disabled value="${user.mobile}"   lay-verify="phone" placeholder="请输入手机" autocomplete="off" class="layui-input">
        </div>
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
                <input type="checkbox" disabled  name="roless" value="${role.id}" ${ role.status=='1'?'checked':''} title="${role.nameZh}"/>
            </c:forEach>
            <%--            <input type="hidden" name="roles" id="roless">--%>
        </div>
    </div>
    <div class="layui-inline">
        <div class="layui-inline">
            <div class="layui-form-item">
                <label class="layui-form-label">用户头像</label>
                <div class="layui-input-inline">
                    <button type="button" disabled class="layui-btn" id="test1">
                        <i class="layui-icon">&#xe67c;</i>上传图片
                    </button>
                </div>

            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">单选框</label>
                <div class="layui-input-block">
                    <input type="radio" name="sex" value="男" disabled title="男" ${user.sex eq '男'?'checked':''}>
                    <input type="radio" name="sex" value="女" disabled title="女" ${user.sex eq '女'?'checked':''}>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">是否启用</label>
                <div class="layui-input-block">
                    <input type="checkbox" name="status"  ${user.status==1?'checked':''} disabled  value="${user.status}"  lay-skin="switch" lay-text="启用|禁用">
                </div>
            </div>
        </div>
        <div class="layui-inline pull-right" id="imgShow">
            <img src="${user.headimg}" id="preShow" width="150px" height="200px" ${empty user.headimg?'style="display: none"':''}>
        </div>
    </div>


<script>

</script>
</body>
</html>
