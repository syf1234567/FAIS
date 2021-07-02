<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>录取查询</title>
<link rel="stylesheet"
	href="/school/static/js/plugins/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/school/static/js/plugins/layui/css/layui.css" media="all">
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
			<legend class="legend-background">录取查询</legend>
		</fieldset>
		<form class="layui-form text-align" name="Student" action="" id="StudentSelect"
			lay-filter="example">

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-inline">
						<input type="text" name="name" lay-verify="title"
							autocomplete="off" placeholder="请输入姓名" class="layui-input">
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">考生号</label>
					<div class="layui-input-inline">
						<input type="text" name="candidateNumber"
							lay-verify="candidateNumber" autocomplete="off"
							placeholder="请输入考生号" class="layui-input">
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-input-block" id="selectParent">
					<button class="layui-btn submit-margin" lay-submit=""
						lay-filter="demo" id="select">查询</button>
				</div>
			</div>
		</form>


		<div class="tail">
			<p style="display:none;" id="close">录取查询已经关闭,若有问题请咨询招生办电话</p>
			<p>咨询电话:0595-22789708，0595-22789808</p>
			<p>传 真:0595-22789648</p>
			<p>注意：请各位预录取新生在查看录取信息时，请注意核对地址及联系电话，以便录取通知书能够顺利送达。</p>
			<!-- <p>备 注: 考生号不足14位，请在前面补充"19"+省份代码，广东省考生请在考生号前加上"1944"补足14位。</p> -->
		</div>
	</div>
	<!-- <table id="data" style="display:none">
		<tr>
		<td >demo</td><td >demo</td><td >demo</td><td >demo</td><td >demo</td><td >demo</td>
		</tr>
		</table> -->
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script src="/school/static/js/jquery-3.3.1.js"></script>
	<script src="/school/static/js/jquery-3.3.1.min.js"></script>
	<script src="/school/static/js/plugins/layui/layui.js" charset="utf-8"></script>
	<script
		src="/school/static/js/plugins/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
	  <script>
		var time, year, month, date, hours, minutes, seconds;
		time = new Date();
		year = time.getFullYear();

		//对日期进行处理,小于10的数在前面加上0
		month = (time.getMonth() + 1) < 10 ? ("0" + (time.getMonth() + 1))
				: (time.getMonth() + 1);
		date = time.getDate() < 10 ? ("0" + time.getDate()) : time.getDate();
		hours = time.getHours() < 10 ? ("0" + time.getHours()) : time
				.getHours();
		minutes = (time.getMinutes() < 10 ? ("0" + time.getMinutes()) : time
				.getMinutes());
		seconds = (time.getSeconds() < 10 ? ("0" + time.getSeconds()) : time
				.getSeconds());

		//拼格式，如：2018-01-15 14:32:57
		time = year + "-" + month + "-" + date + " " + hours + ":" + minutes
				+ ":" + seconds;
		$
				.ajax({
					//url : 'http://qzimp.cn/api/assist/api/config/selectByType?type=学校截止时间',
					url:'${request.contextPath}/api/config/selectByType?type=学校截止时间',
					method : 'post',
					data : '',
					dataType : 'JSON',
					success : function(data) {
						if (data[0].configValue < time) {
							/*找到父元素*/
							var studentSelect = document.getElementById("StudentSelect");
							studentSelect.style.display="none";
							var close = document.getElementById("close");
							close.style.display="";
						}
					}
				});
	</script>
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
																layer
																		.open({
																			type : 1,
																			content : data
																		});
															}
														});
												return false;
											});

						});
	</script>

</body>

</html>