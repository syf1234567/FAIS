<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>填写信息</title>
<link rel="stylesheet"
	href="/school/static/js/plugins/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/school/static/js/plugins/layui/css/layui.css" media="all">
<link rel="stylesheet" href="/school/static/css/scholarship.css">
</head>

<body>
	<div class="container-fluid"
		style="background-image: url(/school/static/images/index-tb-common-bg.png); background-size: 100% 100%; heigth: 160px;">
		<div class="d-flex justify-content-center">
			<img src="/school/static/images/logo-img.png" class="img-fluid">
		</div>
	</div>
	<div class="content container">
		<fieldset
			class="layui-elem-field layui-field-title text-align fieldset-box">
			<legend class="legend-background">基本信息</legend>
		</fieldset>
		<form class="layui-form text-align" name="Scholarship" action=""
			id="scholarship" lay-filter="example">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">科类</label>
					<div class="layui-input-inline" value="">
						<select name="subjectCategoryId" lay-verify="required"
							lay-search="" lay-filter="subjectCategoryId">
							<option value="">请选择科类</option>
							<option value="1">文史</option>
							<option value="2">理工</option>
						</select>
					</div>
				</div>
			</div>
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
					<label class="layui-form-label">预填专业</label>
					<div class="layui-input-inline">
						<select name="majorId" lay-verify="required" id="majorId"
							lay-search="">
							<option value="">请选择预填专业</option>
						</select>
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">分数</label>
					<div class="layui-input-inline">
						<input type="text" name="grade" lay-verify="title"
							autocomplete="off" placeholder="请输入分数" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">预填报志愿</label>
					<div class="layui-input-inline">
						<select name="volunteerNumber" lay-verify="required" lay-search="">
							<option value="">请选择预填志愿</option>
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
							<option value="E">E</option>
							<option value="F">F</option>
							<option value="G">G</option>
							<option value="H">H</option>
							<option value="I">I</option>
							<option value="J">J</option>
						</select>
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
				<div class="layui-inline">
					<label class="layui-form-label">联系方式</label>
					<div class="layui-input-inline">
						<input type="tel" name="contact" lay-verify="required|phone"
							autocomplete="off" class="layui-input" placeholder="请输入联系方式">
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn submit-margin" lay-submit=""
						lay-filter="demo">提交</button>
				</div>
			</div>
		</form>
		<div class="tail">
			<p style="display:none;" id="close">申请奖学金已经关闭,若有问题请咨询招生办电话</p>
			<p>咨询电话:0595-22789708，0595-22789808</p>
			<p>传 真:0595-22789648</p>
		</div>
	</div>
	<script src="/school/static/js/jquery-3.3.1.js"></script>
	<script src="/school/static/js/jquery-3.3.1.min.js"></script>
	<script src="/school/static/js/plugins/layui/layui.js" charset="utf-8"></script>
	<script
		src="/school/static/js/plugins/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
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
		$.ajax({
			//url : 'http://qzimp.cn/api/assist/api/config/selectByType?type=学校截止时间',
			url:'${request.contextPath}/api/config/selectByType?type=学校截止时间',
			method : 'post',
			data : '',
			dataType : 'JSON',
			success : function(data) {
				if (data[1].configValue < time) {
					/*找到父元素*/
					var studentSelect = document
							.getElementById("scholarship");
					studentSelect.style.display = "none";
					var close = document.getElementById("close");
					close.style.display = "";
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

							//日期
							laydate.render({
								elem : '#date',
								type : 'datetime',
								value : new Date(),
								readonly : "readonly"
							});

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

							form
									.on(
											'select(subjectCategoryId)',
											function(data) {
												var subjectCategoryId = data.value;
												$
														.ajax({
															url : '${request.contextPath}/scholarship/selectMajor?subjectCategoryId='
																	+ subjectCategoryId,
															method : 'post',
															data : data.field,
															dataType : 'JSON',
															success : function(
																	data) {
																$("#majorId")
																		.empty();
																$("#majorId")
																		.append(
																				"<option value=''>请选择预填专业</option>");
																if (data.length > 0) {
																	for (var i = 0; i < data.length; i++) {
																		$(
																				"#majorId")
																				.append(
																						"<option value='" + data[i].id + "'>"
																								+ data[i].subjectName
																								+ "</option>");
																	}
																}
																form
																		.render('select');
															}
														});
											});
							//监听提交
							form
									.on(
											'submit(demo)',
											function(data) {
												layer
														.confirm(
																'真的提交么',
																function(index) {
																	$
																			.ajax({
																				url : '${request.contextPath}/scholarship/toedit?operation=insert',
																				method : 'post',
																				data : data.field,
																				success : function(
																						data) {

																					layer
																							.msg(data);
																				}
																			});
																	layer
																			.close(index);
																});
												return false;
											});

						});
	</script>

</body>

</html>