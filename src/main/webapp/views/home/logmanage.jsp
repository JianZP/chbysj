<%--
Created by IntelliJ IDEA.
User: admin
Date: 2020/4/21
Time: 23:47
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>数据操作 - 数据表格</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
</head>
<body>

<div class="layui-card layadmin-header">
  <div class="layui-breadcrumb" lay-filter="breadcrumb">
    <a lay-href="">主页</a>
    <a><cite>组件</cite></a>
    <a><cite>数据表格</cite></a>
    <a><cite>数据操作</cite></a>
  </div>
</div>

<div class="layui-fluid">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md12">
      <div class="layui-card">
        <div class="layui-card-header">数据操作</div>
        <div class="layui-card-body">
          <div class="test-table-operate-btn" style="margin-bottom: 10px;">
            <button class="layui-btn" data-type="getCheckLength" style="margin-left: 0px">导出</button>
            <div class="layui-inline">

              <input class="layui-input" name="keyword" id="keyword" autocomplete="off" placeholder="用户名">
            </div>
            <button class="layui-btn" data-type="search" >查询</button>
          </div>
          <table class="layui-hide" id="test-table-operate" lay-filter="test-table-operate"></table>
<%--          <script type="text/html" id="test-table-operate-barDemo">--%>
<%--            <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">导出</a>--%>
<%--          </script>--%>
        </div>
      </div>
    </div>
  </div>
</div>
<iframe id="ifile" style="display:none"></iframe>
<script src="../../../layuiadmin/layui/layui.js"></script>
<script>
  layui.config({
    base: '../../../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'table'], function(){
    var table = layui.table
            ,admin = layui.admin;
    var input=document.getElementById("keyword");
    var username=input.value;
    table.render({
      elem: '#test-table-operate'
      ,url: 'http://localhost:8080/selAllUser?'+'username'+username
      ,width: admin.screen() > 1 ? 730: ''
      ,height: 472.5
      ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
        layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
        ,groups: 1 //只显示 1 个连续页码
        ,first: true //不显示首页
        ,last: true //不显示尾页
      }
      ,cols: [[
        {type:'checkbox', fixed: 'left'}
        ,{field:'id', width:80, title: 'ID', sort: true}
        ,{field:'username', width:200, title: '用户名'}
        ,{field:'signintime', width:200, title: '上次登录时间'}
        ,{field:'signout', width:200, title: '上次登出时间'}
        // ,{width:166.6, align:'center', toolbar: '#test-table-operate-barDemo'}
      ]]
      ,page: true
    });

    //监听表格复选框选择
    table.on('checkbox(test-table-operate)', function(obj){
      console.log(obj)
    });
    //监听工具条
    table.on('tool(test-table-operate)', function(obj){
      var data = obj.data;
      if(obj.event === 'detail'){
        layer.msg('ID：'+ data.id + ' 的查看操作');
      } else if(obj.event === 'edit'){

      } else if(obj.event === 'del'){
        layer.confirm('确定删除吗？', function(index){
          layer.close(index);
        });
      }
    });

    var $ = layui.$, active = {
      getCheckData: function(){ //获取选中数据
        var checkStatus = table.checkStatus('test-table-operate')
                ,data = checkStatus.data;
        layer.alert(list);
      }
      ,getCheckLength: function(){ //获取选中数目
        var checkStatus = table.checkStatus('test-table-operate')
                ,data = checkStatus.data;
        var arr=new Array();
        for (var i=0;i<data.length;i++) {
          arr[i]=data[i].id;
        }
        alert(JSON.stringify(arr));
        var dom=document.getElementById('ifile');
        dom.src=" http://localhost:8080/ExcelDownloadsLog?ids="+JSON.stringify(arr);
      }
      ,search:function () {//搜索
        var input=document.getElementById("keyword");
        var username=input.value;
        table.render({
          elem: '#test-table-operate'
          ,url: 'http://localhost:8080/selAllUser?'+'username='+username
          ,width: admin.screen() > 1 ? 730: ''
          ,height: 472.5
          ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            ,groups: 1 //只显示 1 个连续页码
            ,first: true //不显示首页
            ,last: true //不显示尾页
          }
          ,cols: [[
            {type:'checkbox', fixed: 'left'}
            ,{field:'id', width:80, title: 'ID', sort: true}
            ,{field:'username', width:200, title: '用户名'}
            ,{field:'signintime', width:200, title: '上次登录时间'}
            ,{field:'signout', width:200, title: '上次登入时间'}
          ]]
          ,page: true
        });
      }
      ,isAll: function(){ //验证是否全选
      }
    };

    $('.test-table-operate-btn .layui-btn').on('click', function(){
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });
  });
</script>
</body>
</html>