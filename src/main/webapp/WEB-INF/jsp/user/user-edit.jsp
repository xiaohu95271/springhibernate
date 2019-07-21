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
    <title>用户管理-编辑</title>
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
            <input type="text" name="name" required  value="${user.name}" lay-verify="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            <input type="hidden" name="id" required  value="${user.id}" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机</label>
        <div class="layui-input-inline">
            <input type="text" name="mobile" required  value="${user.mobile}"   lay-verify="phone" placeholder="请输入手机" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password"  value="${user.password}"  required lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
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
                    <input type="checkbox"  name="roless" value="${role.id}" ${ role.status=='1'?'checked':''} title="${role.nameZh}"/>
            </c:forEach>
            <%--            <input type="hidden" name="roles" id="roless">--%>
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

                <input type="hidden"   value="${user.headimg}"  name="headimg" id="headimg">
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">单选框</label>
                <div class="layui-input-block">
                    <input type="radio" name="sex" value="男" title="男" ${user.sex eq '男'?'checked':''}>
                    <input type="radio" name="sex" value="女" title="女" ${user.sex eq '女'?'checked':''}>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">是否启用</label>
                <div class="layui-input-block">
                    <input type="checkbox" name="status"  ${user.status==1?'checked':''}   value="${user.status}"  lay-skin="switch" lay-text="启用|禁用">
                </div>
            </div>
        </div>
        <div class="layui-inline pull-right" id="imgShow">
            <img src="${user.headimg}" id="preShow" width="150px" height="200px" ${empty user.headimg?'style="display: none"':''}>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" type="button"  lay-submit lay-filter="formDemo">立即提交</button>
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
            ,field:"headImage"
            // ,headers:{"Content-Type":"multipart/form-data"}
            ,done: function(res){
                layer.closeAll('loading');
                //上传完毕回调
                $("#headimg").val("http://"+res.filePath)
                $("#imgShow").html("<img src=\"http://"+res.filePath+"\" id=\"headImg\" width=\"150px\" height=\"200px\">")
                layer.msg("上传成功！",{icon:1})
            }
            ,error: function(){
                //请求异常回调
                layer.closeAll('loading');
                layer.msg("上传失败！",{icon:5})
            },
            before: function(obj){
                layer.load(); //上传loading
                $("#preShow").show()
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#preShow').attr('src', result); //图片链接（base64）
                });
            }
        });
    });
    //Demo

    layui.use('form', function(){
        var form = layui.form;
        // var chk_value =[];//定义一个数组
        // $('input[name="role"]:checked').each(function(){//遍历每一个名字为nodes的复选框，其中选中的执行函数
        //     chk_value.push($(this).val());//将选中的值添加到数组chk_value中
        // });
        // var roles = chk_value.join(",");
        // $("#roless").val(roles);

        // form.on('checkbox(filter)', function(data){
        //     console.log(data.elem); //得到checkbox原始DOM对象
        //     console.log(data.elem.checked); //是否被选中，true或者false
        //     console.log(data.value); //复选框value值，也可以通过data.elem.value得到
        //     console.log(data.othis); //得到美化后的DOM对象
        // });
        form.verify({
            username: function(value, item){ //value：表单的值、item：表单的DOM对象
                if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                    return '用户名不能有特殊字符';
                }
                if(/(^\_)|(\__)|(\_+$)/.test(value)){
                    return '用户名首尾不能出现下划线\'_\'';
                }
                if(/^\d+\d+\d$/.test(value)){
                    return '用户名不能全为数字';
                }
            }

            //我们既支持上述函数式的方式，也支持下述数组的形式
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
        });
        //监听提交
        form.on('submit(formDemo)', function(data){
            submitForm($("#dataForm").serialize(),"${path}/user/editUser");
            return false;
        });
    });

</script>
</body>
</html>
