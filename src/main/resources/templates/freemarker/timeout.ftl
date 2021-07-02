<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>录取查询</title>
<link rel="stylesheet"
	href="/school/static/js/plugins/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/school/static/js/plugins/layui/css/layui.css"
	media="all">
<link rel="stylesheet" href="/school/static/css/scholarship.css">
</head>

<body>
	<div class="container-fluid"
		style="background-image: url(/school/static/images/index-tb-common-bg.png); background-size: 100% 100%; height: 160px;">
		<div class="d-flex justify-content-center">
			<img src="/school/static/images/logo-img.png" class="img-fluid">
		</div>
	</div>
	<div class="content container">
		<fieldset
			class="layui-elem-field layui-field-title text-align fieldset-box">
			<legend class="legend-background">时间已到期</legend>
		</fieldset>

	</div>
	<!-- <table id="data" style="display:none">
		<tr>
		<td >demo</td><td >demo</td><td >demo</td><td >demo</td><td >demo</td><td >demo</td>
		</tr>
		</table> -->
	<script src="/school/static/js/jquery-3.3.1.js"></script>
	<script src="/school/static/js/jquery-3.3.1.min.js"></script>
	<script src="/school/static/js/plugins/layui/layui.js" charset="utf-8"></script>
	<script
		src="/school/static/js/plugins/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
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
									if (value.length < 2) {
										return '至少得2个字符啊';
									}
								},
								candidateNumber : function(value) {
									if (value.length < 1) {
										return '请输入考生号';
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
															url : '${request.contextPath}/newStudent/select',
															method : 'post',
															data : data.field,
															success : function(
																	data) {
																/* layer
																		.alert(data); */
																layer.open({
																			type:1,
																			content:data
																			});
															}
														});
												return false;
											});

						});
	</script>

</body>

</html>