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
          <table class="layui-hide" id="test-table-operate" lay-filter="test-table-operate"></table>
          <script type="text/html" id="test-table-operate-barDemo">
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit">修改设备状态</a>
          </script>
        </div>
      </div>
    </div>
  </div>
</div>
<input id="keyword" name="keyword" style="display: none">
<!--修改状态弹出层-->
<div class="layui-row" id="popSetTest" style="display:none;">
  <div class="layui-col-md10">
    <form class="layui-form layui-from-pane" action="" style="margin-top:20px" id="power" >
      <div class="layui-form-item" style="display: none">
        <label class="layui-form-label">ID</label>
        <div class="layui-input-block">
          <input type="text" id="id" name="id" required  lay-verify="required" autocomplete="off" placeholder="" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">使用年限</label>
        <div class="layui-input-block">
          <input type="text" name="uselimit"  required  lay-verify="required" autocomplete="off" placeholder="使用年限" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
          <select name="status" lay-filter="status">
            <option value="启用">启用</option>
            <option value="停用" selected="">停用</option>
          </select>
        </div>
      </div>
      <div class="layui-form-item" style="margin-top:40px">
        <div class="layui-input-block">
          <button class="layui-btn  layui-btn-submit " lay-submit="" lay-filter="power">确认修改</button>
          <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
      </div>
    </form>
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
    var name=input.value;
    table.render({
      elem: '#test-table-operate'
      ,url: 'http://localhost:8080/selEquipType?name='+name
      ,width: admin.screen() > 1 ? 890: ''
      ,height: 472.5
      ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
        layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
        ,groups: 1 //只显示 1 个连续页码
        ,first: true //不显示首页
        ,last: true //不显示尾页
      }
      ,cols: [[
       {field:'id', width:80, title: 'ID', sort: true}
        ,{field:'name', width:200, title: '设备名称'}
        ,{field:'uselimit', width:200, title: '使用年限'}
        ,{field:'status', width:200, title: '状态'}
        ,{width:166.6, align:'center', toolbar: '#test-table-operate-barDemo'}
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
        $("#id").val(data.id)
        layer.open({
          type: 1,
          title: "修改设备类型信息",
          area: ['420px', '350px'],
          content: $("#popSetTest")//引用的弹出层的页面层的方式加载修改界面表单
        });
      } else if(obj.event === 'del'){
      }
    });

    var $ = layui.$, active = {
      getCheckData: function(){ //获取选中数据
        var checkStatus = table.checkStatus('test-table-operate')
                ,data = checkStatus.data;
        layer.alert(list);
      }
  };

    $('.test-table-operate-btn .layui-btn').on('click', function(){
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });
    layui.form.on('submit(power)', function(data){
      $.ajax({
        url:'http://localhost:8080/updEquipType',
        method:'post',
        data:data.field,
        dataType:'JSON',
        success:function(res){
          if(res.code='0'){
            layer.msg('修改成功！', {
              offset: '15px'
              ,icon: 1
            });
          }
          else
            alert(res.msg);
        },
        error:function (data) {

        }
      }) ;
    });
  });
</script>
</body>
</html>