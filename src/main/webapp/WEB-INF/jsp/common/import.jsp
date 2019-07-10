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

<link rel="stylesheet" href="${path}/resource/css/layui.css"  />



<script type="text/javascript" src="${path}/resource/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${path}/resource/js/jquery.form.min.js"></script>
<script type="text/javascript" src="${path}/resource/js/layui.js"></script>