<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>登录页面</title>
<link rel="stylesheet"
	href="/school/static/js/plugins/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/school/static/js/plugins/layui/css/layui.css"
	media="all">
<link rel="stylesheet" href="/school/static/css/scholarship.css">
<link rel="stylesheet" href="/school/static/css/login.css">
</head>

<body>
	<div class="content">
		<div class="content-image-box">
			<div class="content-title">新生信息管理登录</div>
			<form class="layui-form text-align" name="TeacherLogin" action=""
				lay-filter="example">

				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label text-color-white">工号</label>
						<div class="layui-input-inline">
							<input type="text" name="staffNumber" lay-verify="title"
								autocomplete="off" placeholder="请输入教职工号" class="layui-input">
						</div>
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label text-color-white">密码</label>
						<div class="layui-input-inline">
							<input type="password" name="password" lay-verify="title"
								autocomplete="off" placeholder="请输入密码" class="layui-input">
						</div>
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn submit-margin" lay-submit=""
							lay-filter="demo">登录</button>
					</div>
				</div>
			</form>
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
						[ 'form', 'layedit', 'laydate' ],
						function() {
							var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;

							//创建一个编辑器
							var editIndex = layedit.build('LAY_demo_editor');

							//自定义验证规则
							form.verify({
								title : function(value) {
									if (value.length < 1) {
										return '至少得1个字符啊';
									}
								},
							});

							//监听提交
							form
									.on(
											'submit(demo)',
											function(data) {
												$
														.ajax({
															url : '${request.contextPath}/teacher/login',
															method : 'post',
															data : data.field,
															success : function(
																	data) {
																if (data == "登录失败") {
																	layer
																			.alert("账号或密码错误");
																}
																if(data == "登录成功"){
																	var link = '${request.contextPath}/management';
																	window.location.href = link;
																	}
															},
														});
												return false;
											});

						});
	</script>

</body>

</html>