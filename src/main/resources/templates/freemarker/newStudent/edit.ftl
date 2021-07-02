<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>填写信息</title>
<link rel="stylesheet" href="/school/static/js/plugins/layui/css/layui.css"
	media="all">
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>奖学金申报填写信息</legend>
	</fieldset>
	<form class="layui-form" name="student" action="" lay-filter="example">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">科类</label>
				<div class="layui-input-inline" value="">
					<select name="subjectCategoryId" lay-verify="required"
						lay-search="" lay-filter="subjectCategoryId" >
						<option value="">请选择</option>
						<option value="1">文史</option>
						<option value="2">理工</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">姓名</label>
				<div class="layui-input-block">
					<input type="text" name="name" lay-verify="title"
						autocomplete="off" placeholder="请输入姓名" class="layui-input">
				</div>
			</div>

		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">考生号</label>
				<div class="layui-input-block">
					<input type="text" name="candidateNumber" lay-verify="title"
						autocomplete="off" placeholder="请输入考生号" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">分数</label>
				<div class="layui-input-block">
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
						<option value="">请选择</option>
						<option value="1">A</option>
						<option value="2">B</option>
						<option value="3">C</option>
						<option value="4">D</option>
						<option value="5">E</option>
						<option value="6">F</option>
						<option value="7">G</option>
						<option value="8">H</option>
						<option value="9">I</option>
						<option value="10">J</option>
					</select>
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">预填专业</label>
				<div class="layui-input-inline">
					<select name="majorId" lay-verify="required" id="majorId" lay-search="">
						<option value="">请选择</option>
					</select>
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
				<button class="layui-btn" lay-submit="" lay-filter="demo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>

	<script src="/school/static/js/jquery-3.3.1.js"></script>
	<script src="/school/static/js/jquery-3.3.1.min.js"></script>
	<script src="/school/static/js/plugins/layui/layui.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
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
								}
							});

							form
									.on(
											'select(subjectCategoryId)',
											function(data) {
												var subjectCategoryId = data.value;
												$
												.ajax({
													url : '${request.contextPath}/student/selectMajor?subjectCategoryId='
														+ subjectCategoryId,
													method : 'post',
													data : data.field,
													dataType : 'JSON',
													success:function(data){	
														$("#majorId").empty();
														$("#majorId").append("<option value=''>请选择</option>");							
														if(data.length>0){					
															 for(var i = 0;i<data.length;i++){
																 	$("#majorId").append("<option value='"+data[i].id+"'>"+data[i].subjectName+"</option>");
																} 
															}
														form.render('select');
														} 
												});	
											})
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
																				url : '${request.contextPath}/student/toedit?operation=insert',
																				method : 'post',
																				data : data.field,
																				dataType : 'JSON',
																				success:function(data){
																					 layer.msg(data);
																					}
																			});																	
																});
												return false;
											});

						});
	</script>

</body>
</html>