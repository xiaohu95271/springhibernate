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

    $(function() {
        layui.use('tree', function(){
            $.ajax({
                url:"${path}/menu/menuData",
                dataType:"json",
                success:function(menu) {
                    var tree = layui.tree;
                    //渲染
                    var inst1 = tree.render({
                        elem: '#test1', //绑定元素
                        data: menu,
                        edit: ['add', 'update', 'del'],
                        showCheckbox:false,//选择框
                        click: function(obj){//单机事件
                            // console.log(obj.data); //得到当前点击的节点数据
                            // console.log(obj.state); //得到当前节点的展开状态：open、close、normal
                            // console.log(obj.elem); //得到当前节点元素
                            //
                            // console.log(obj.data.children); //当前节点下是否有子节点
                            layer.open({
                                type: 2,
                                anim: 1, //默认动画风格
                                title: "菜单修改",
                                area: ['650px', '400px'],
                                skin: 'layui-layer-molv', //默认皮肤
                                content: ['${path}/menu/toMenuEditPage?id='+obj.data.id,'yes'] //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                            });
                                                },
                        operate: function(obj){
                            var type = obj.type; //得到操作类型：add、edit、del
                            var data = obj.data; //得到当前节点的数据
                            var elem = obj.elem; //得到当前节点元素
                            //Ajax 操作
                            var id = data.id; //得到节点索引
                            if(type === 'add'){ //增加节点
                                //返回 key 值
                                $.ajax({
                                    url:"${path}/menu/add?id="+id,
                                    dataType:"json",
                                    success:function(menu) {

                                     }
                                });
                                return 123;
                            } else if(type === 'update'){ //修改节点
                                $.ajax({
                                    url:"${path}/menu/update",
                                    dataType:"json",
                                    success:function(menu) {

                                     }
                                });
                                console.log(elem.find('.layui-tree-txt').html()); //得到修改后的内容
                                console.log(type)
                            } else if(type === 'del'){ //删除节点
                                $.ajax({
                                    url:"${path}/menu/del",
                                    dataType:"json",
                                    success:function(menu) {

                                    }
                                });
                                console.log(type)
                            };
                        }
                    });
                }
            })
        })


  });
</script>
</body>
</html>



