<%@ page import="com.xiaohu.demo.common.DateUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 2019/7/10
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

    String nowDate = DateUtil.getDate();
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="<%=path%>"></c:set>
<c:set var="basePath" value="<%=basePath%>"></c:set>
<script>
    var path = "${path}";
</script>


<link rel="stylesheet" href="${path}/resource/css/layui.css"  />
<link rel="stylesheet" href="${path}/layui/css/modules/layer/default/layer.css"  />



<script type="text/javascript" src="${path}/resource/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${path}/resource/js/jquery.form.min.js"></script>
<script type="text/javascript" src="${path}/resource/js/layui.js"></script>
<script type="text/javascript" src="${path}/layui/lay/modules/layer.js"></script>
<script>
    layui.use(['layer', 'form'], function(){
        var layer = layui.layer
            ,form = layui.form;

    });

    /**
     * 弹出层的添加方法
     * @param data 提交数据
     * @param url 提交url
     * @param backUrl 成功跳转url
     */
    function submitForm(data,url,backUrl) {
        var index = layer.load(2, {time: 100*1000}); //又换了种风格，并且设定最长等待10秒
        $.ajax({
            type: "post",  //提交方式
            dataType: "json", //数据类型
            data:data,//自定义数据参数，视情况添加
            url: url, //请求url
            success: function (data) { //提交成功的回调函数
                layer.closeAll('loading');
                layer.msg('添加成功', {icon: 6,time: 5000});
                layer.closeAll('iframe');
            }
        })
    }
</script>