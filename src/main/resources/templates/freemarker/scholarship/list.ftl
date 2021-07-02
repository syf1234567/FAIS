<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>奖学金信息管理</title>
<link rel="stylesheet"
	href="/school/static/js/plugins/layui/css/layui.css" media="all">

</head>

<body>
	<div class="layui-btn-group demoTable" style="margin: 1% 0 0 1.1%;">
		<a class="layui-btn"
			href="${request.contextPath}/scholarship/toexport"
			data-type="exportExcle">导出excle</a>
		<form class="layui-form" lay-filter="example">
			<div style="margin-left: 400px; font-size: 15px; margin-top: -20px;">
				请选择要截止的日期：</div>
			<div style="margin-left: 550px; font-size: 15px; margin-top: -33px;">
				<input type="text" class="layui-input" id="test1" name="time"
					value="2099-01-01 00:00:00" style="width: 200px;">
			</div>
			<div style="margin-left: 766px; margin-top: -38px;">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
				<button class="layui-btn" type="button" id="deleteAllData" style="margin-left:10px !important;">删除所有数据</button>
			</div>
		</form>
	</div>
	<div class="layui-tab layui-tab-card">
		<ul class="layui-tab-title">
			<li class="layui-this">奖学金学生信息</li>
		</ul>
		<div class="layui-tab-content" style="height: 495px; width: 98%;">
			<!--系统配置 -->
			<div class="layui-tab-item layui-show">
				<div class="layui-card-body" style="margin: -30px 0px 0px -25px;">
					<table class="layui-table" lay-data="{height:472, page:true}"
						lay-filter="demo">
						<thead>
							<tr>
								<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
								<th lay-data="{field:'id', width:180, sort:true}">ID</th>
								<th lay-data="{field:'name', width:180}">姓名</th>
								<th lay-data="{field:'candidateNumber', width:180}">考生号</th>
								<th lay-data="{field:'grade', width:180}">成绩</th>
								<th lay-data="{field:'volunteerNumber', width:180}">预填志愿号</th>
								<th lay-data="{field:'majorId', width:180}">预填专业</th>
								<th lay-data="{field:'contact', width:180}">联系方式</th>
								<th lay-data="{field:'fillTime',fixed: 'right', width:180}">填报时间</th>
							</tr>
						</thead>
						<tbody>
							<#list scholarships as scholarship>
							<tr>
								<td></td>
								<td>${scholarship.id}</td>
								<td>${scholarship.name}</td>
								<td>${scholarship.candidateNumber}</td>
								<td>${scholarship.grade}</td>
								<td>${scholarship.volunteerNumber}</td>
								<td>${scholarship.majorId}</td>
								<td>${scholarship.contact}</td>
								<td>${scholarship.fillTime}</td>
							</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="/school/static/js/jquery-3.3.1.js"></script>
	<script src="/school/static/js/jquery-3.3.1.min.js"></script>
	<script src="/school/static/js/plugins/layui/layui.js" charset="utf-8"></script>
	<script src="/school/static/js/plugins/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
		layui
				.use(
						['form', 'util', 'laydate', 'layer' ],
						function() {
							var form = layui.form,util = layui.util, laydate = layui.laydate, layer = layui.layer;
						  $
							.ajax({
								//url : 'http://qzimp.cn/api/assist/api/config/selectByType?type=学校截止时间',
								url:'${request.contextPath}/api/config/selectByType?type=学校截止时间',
								method : 'post',
								data : '',
								dataType : 'JSON',
								success : function(
										data) {
									 form.val('example', {
										    "time": data[1].configValue // "name": "value"
										  })
								}
							});  
						  $("#deleteAllData").click(function(){
								layer.confirm("确认删除吗？",{
									},function(index,layero){
											$.ajax({
												url:"${request.contextPath}/scholarship/deleteAllData",
												success:function(){
													window.location.href="${request.contextPath}/scholarship/list"
												},
												error:function(){
													console.log("失败");
													}
											})
									},function(index){
										console.log(index);
									});
						})
							laydate.render({
								elem : '#test1',
								type : 'datetime'
							});
							//监听提交
							form.on('submit(demo1)', function(formdata) {
								 var time=formdata.field.time;
								var config='{"id":50,"configKey":"新生录取截止时间","configValue":"'+formdata.field.time+'","dataType":"text","type":"学校截止时间","enable":"使用"}}';
								$
										.ajax({
											//url : 'http://qzimp.cn/api/assist/api/config/update',
											url : '${request.contextPath}/api/config/update',
											method : 'post',
											contentType:"application/json;charset=UTF-8",
											data : config,
											dataType : 'JSON',
											success : function(
													data) {
												layer.alert('设置成功');
											},
											error:function(data){
												layer.alert('设置成功');
												},
										});
								return false;
							});
						});
	</script>
	<script>
		layui.use('table', function() {
			var table = layui.table, form = layui.form;
			//监听表格复选框选择
			table.on('checkbox(demo)', function(obj) {
				console.log(obj)
			});

			var $ = layui.$, active = {
			/* exportExcle: function () { //获取选中数据
				 $.ajax({
			         type: "post",
			         url: "${request.contextPath}/excel/scholarship/toexport",
			         success: function(data){
			                     layer.msg(data);
			                  }
			     }); 
			}*/
			};

			$('.demoTable .layui-btn').on('click', function() {
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});
		});
	</script>
</body>

</html>