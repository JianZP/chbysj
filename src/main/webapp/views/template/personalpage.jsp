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
            <button class="layui-btn" data-type="add" style="margin-left: 0px">添加设备信息</button>
            <button class="layui-btn" data-type="getCheckLength" style="margin-left: 0px">导出</button>
            <button class="layui-btn" data-type="isAll" style="margin-left: 0px">导入</button>
            <div class="layui-inline">
              <input class="layui-input" name="keyword" id="keyword" autocomplete="off" placeholder="请输入生产厂家">
            </div>
            <button class="layui-btn" data-type="search" >查询</button>
          </div>
          <table class="layui-hide" id="test-table-operate" lay-filter="test-table-operate"></table>
          <script type="text/html" id="test-table-operate-barDemo">
            <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">修改</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
          </script>
        </div>
      </div>
    </div>
  </div>
</div>
<!--导入-->
<div class="layui-row" id="uploadfile" style="display:none;">
  <div class="layui-col-md10">
    <form method="post"  enctype="multipart/form-data" id="form1" action="http://localhost:8080/fileUploadInfo">
      <div class="layui-form-item">
        <label class="layui-form-label">导入信息</label>
        <div class="layui-input-block">
          <input id="upfile" type="file" name="upfile" accept=".xls,.xlsx" />
        </div>
      </div>
      <div class="layui-form-item" style="margin-top:40px">
        <div class="layui-input-block">
          <input  type="submit" class="layui-btn  layui-btn-submit" value="提交" onclick="checkData()" />
        </div>
      </div>
    </form>
  </div>
</div>

<!--添加弹出层-->
<div class="layui-row" id="popUpdateTest" style="display:none;">
  <div class="layui-col-md10">
    <form class="layui-form layui-from-pane" action="" style="margin-top:20px" id="myform" >
      <div class="layui-form-item">
        <label class="layui-form-label">生产厂家</label>
        <div class="layui-input-block">
          <input type="text" name="madefactor"  required  lay-verify="required" autocomplete="off" placeholder="生产厂家" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">品牌</label>
        <div class="layui-input-block">
          <input type="text" name="brand"  required  lay-verify="required" autocomplete="off" placeholder="品牌" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">生产时间</label>
        <div class="layui-input-block">
          <input type="text" name="madetime"  required  lay-verify="required" autocomplete="off" placeholder="生产时间" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">功能</label>
        <div class="layui-input-block">
          <input type="text" name="function"  required  lay-verify="required" autocomplete="off" placeholder="功能" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item" style="margin-top:40px">
        <div class="layui-input-block">
          <button class="layui-btn  layui-btn-submit " lay-submit="" lay-filter="sub">确认添加</button>
          <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
      </div>
    </form>
  </div>
</div>
<!--设置权限弹出层-->
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
        <label class="layui-form-label">生产厂家</label>
        <div class="layui-input-block">
          <input type="text" name="madefactor"  required  lay-verify="required" autocomplete="off" placeholder="生产厂家" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">品牌</label>
        <div class="layui-input-block">
          <input type="text" name="brand"  required  lay-verify="required" autocomplete="off" placeholder="品牌" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">生产时间</label>
        <div class="layui-input-block">
          <input type="text" name="madetime"  required  lay-verify="required" autocomplete="off" placeholder="生产时间" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">功能</label>
        <div class="layui-input-block">
          <input type="text" name="function"  required  lay-verify="required" autocomplete="off" placeholder="功能" class="layui-input">
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
    var madefactor=input.value;
    table.render({
      elem: '#test-table-operate'
      ,url: 'http://localhost:8080/selEquipInfo?'+'madefactor='+madefactor
      ,width: admin.screen() > 1 ? 1090: ''
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
        ,{field:'madefactor', width:200, title: '生产厂家'}
        ,{field:'brand', width:200, title: '品牌'}
        ,{field:'madetime', width:200, title: '生产时间'}
        ,{field:'function', width:200, title: '功能'}
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
        layer.confirm('确定删除吗？', function(index){
          $.ajax({
            url:'http://localhost:8080/delEquipInfo',
            method:'post',
            data:{id:data.id},
            dataType:'JSON',
            success:function(res){
              if(res.code='0'){
                var input=document.getElementById("keyword");
                var madefactor=input.value;
                table.render({
                  elem: '#test-table-operate'
                  ,url: 'http://localhost:8080/selEquipInfo?'+'madefactor='+madefactor
                  ,width: admin.screen() > 1 ? 1090: ''
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
                    ,{field:'madefactor', width:200, title: '生产厂家'}
                    ,{field:'brand', width:200, title: '品牌'}
                    ,{field:'madetime', width:200, title: '生产时间'}
                    ,{field:'function', width:200, title: '功能'}
                    ,{width:166.6, align:'center', toolbar: '#test-table-operate-barDemo'}
                  ]]
                  ,page: true
                });
                layer.msg('删除成功！', {
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
        dom.src=" http://localhost:8080/ExcelDownloadsInfo?ids="+JSON.stringify(arr);
      }
      ,add:function () {
        layer.open({
          //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
          type: 1,
          title: "修改设备类型信息",
          area: ['420px', '350px'],
          content: $("#popUpdateTest")//引用的弹出层的页面层的方式加载修改界面表单
        });
      }
      ,search:function () {//搜索
        var input=document.getElementById("keyword");
        var madefactor=input.value;
        table.render({
          elem: '#test-table-operate'
          ,url: 'http://localhost:8080/selEquipInfo?'+'madefactor='+madefactor
          ,width: admin.screen() > 1 ? 1090: ''
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
            ,{field:'madefactor', width:200, title: '生产厂家'}
            ,{field:'brand', width:200, title: '品牌'}
            ,{field:'madetime', width:200, title: '生产时间'}
            ,{field:'function', width:200, title: '功能'}
            ,{width:166.6, align:'center', toolbar: '#test-table-operate-barDemo'}
          ]]
          ,page: true
        });
      }
      ,isAll: function(){ //验证是否全选
        layer.open({
          type: 1,
          title: "修改设备类型信息",
          area: ['420px', '350px'],
          content: $("#uploadfile")//引用的弹出层的页面层的方式加载修改界面表单
        });
      }
    };

    $('.test-table-operate-btn .layui-btn').on('click', function(){
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });
    layui.form.on('submit(power)', function(data){
      $.ajax({
        url:'http://localhost:8080/updEquipInfo',
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
    layui.form.on('submit(sub)', function(data){
      $.ajax({
        url:'http://localhost:8080/insEquipInfo',
        method:'post',
        data:data.field,
        dataType:'JSON',
        success:function(res){
          if(res.code='0'){
            layer.msg('添加成功！', {
              offset: '15px'
              ,icon: 1
            });
          }
          else
            layer.alert(res.msg);
        },
        error:function (data) {

        }
      }) ;
    });
    //JS校验form表单信息
    function checkData(){
      var fileDir = $("#upfile").val();
      var suffix = fileDir.substr(fileDir.lastIndexOf("."));
      if("" == fileDir){
        layer.alert("选择需要导入的Excel文件！");
        return false;
      }
      if(".xls" != suffix && ".xlsx" != suffix ){
        layer.alert("选择Excel格式的文件导入！");
        return false;
      }
      return true;
    }
  });
</script>
</body>
</html>