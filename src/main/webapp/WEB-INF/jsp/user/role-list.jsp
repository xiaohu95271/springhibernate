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

<table class="layui-hide" id="demo" lay-filter="test"></table>

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

    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function () {
        var laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , element = layui.element //元素操作
            , slider = layui.slider //滑块

        //监听Tab切换
        element.on('tab(demo)', function (data) {
            layer.tips('切换了 ' + data.index + '：' + this.innerHTML, this, {
                tips: 1
            });
        });

        //执行一个 table 实例
        var tableIns = table.render({
            elem: '#demo'
            , height: 500
            , url: '${path}/user/roleList' //数据接口
            , title: '角色表'
            , page: true //开启分页
            , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            // , totalRow: true //开启合计行
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'nameZh', title: '名称', sort: true, totalRow: true}
                , {field: 'nameEn', title: '标识',}
                , {fixed: 'right', align: 'center', toolbar: '#barDemo'}
            ]]
        });

        //监听工具条
        table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent === 'detail'){ //查看
                //do somehing
                layer.open({
                    type: 2,
                    //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    content: '${path}/user/roleEdit?id='+data.id+"&type=1",
                    area: ['650px', '500px'],
                    end:function () {
                        // tableIns.reload();
                    }
                })

            } else if(layEvent === 'del'){ //删除
                layer.confirm('真的删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    $.ajax({
                        "url":'${path}/user/roleDel',
                        "data":{"id":data.id},
                        "dataType":"json",
                        "success":function (result) {
                            layer.msg('删除成功');
                            tableIns.reload();
                        }
                    })
                });
            } else if(layEvent === 'edit'){ //编辑
                //do something
                layer.open({
                    type: 2,
                    //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    content: '${path}/user/roleEdit?id='+data.id,
                    area: ['650px', '500px'],
                    end:function () {
                        // tableIns.reload();
                    }
                })
            }
        });


        //监听头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id)
                , data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.open({
                        type: 2,
                        //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                        content: '${path}/user/roleAdd',
                        area: ['650px', '450px'],
                        end:function () {
                            tableIns.reload();
                        }
                    })
                    break;
                case 'update':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else if (data.length > 1) {
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.open({
                            type: 2,
                            //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                            content: '${path}/user/roleEdit?id='+data[0].id,
                            area: ['650px', '500px'],
                            end:function () {
                                // tableIns.reload();
                            }
                        })
                    }
                    break;
                case 'delete':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else {

                        layer.confirm('确定删除数据?', function(index){
                            //do something
                            var str = "";
                            for (var x =0;x < data.length;x ++) {
                                if (x == data.length){
                                    str += data[x].id;
                                } else {
                                    str += data[x].id + ",";
                                }
                            }

                            $.ajax({
                                "url":'${path}/user/roleDel',
                                "data":{"id":str},
                                "dataType":"json",
                                "success":function (result) {
                                    layer.msg('删除成功');
                                    tableIns.reload();
                                }
                            })

                            layer.close(index);
                        });


                    }
                    break;
            }
            ;
        });


    });


</script>
</body>
</html>
