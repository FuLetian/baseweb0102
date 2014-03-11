<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${basePath}h/javascript/bootstrap-google/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${basePath}h/javascript/jquery-1.9.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${basePath}h/javascript/bootstrap-google/js/bootstrap.min.js"></script>

<!--knockout-->
<script src="${basePath}h/javascript/knockout-3.0.0.js"></script>

<!--jquery.form-->
<script src="${basePath}h/javascript/jquery.form.js"></script>

<script type="text/javascript">

$(function(){
	$("#form").submit(function(){
		
		if(!$("input[name='imgFile']").val()){
			$("input[name='logoPath']").val("${user.logoPath}");
			$("#form").ajaxSubmit({
				url:"${basePath}user-manage/update",
				type:'post',
				dataType:'json',
				success:function(data){
					if(data.result){
						alert("更新成功");
					}
				}
			});
			return false;
		}
		$("#form").ajaxSubmit({
			type:'post',
			dataType:'json',
			url:"${basePath}util/upload",
			success:function(data){
				if(data.result){
					$("input[name='logoPath']").val(data.path);
					$("#form").ajaxSubmit({
						url:"${basePath}user-manage/update",
						type:'post',
						dataType:'json',
						success:function(data){
							if(data.result){
								alert("更新成功");
							}
						}
					});
				}
			}
		});
		return false;
	});
});
</script>

<div class="container">

<form id="form" class="form-horizontal"  enctype ="multipart/form-data">

<fieldset>
<legend>关于我们</legend>
<div class="control-group">
	<input type="hidden" name="id" value="${user.id}">
	<input type="hidden" name="logoPath">
    <label class="control-label" for="inputEmail">基本信息</label>
    <div class="controls">
      <textarea rows="" cols="" name="basicInfo">${user.basicInfo}</textarea>
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputPassword">服务理念</label>
    <div class="controls">
      <textarea rows="" cols="" name="serviceInfo">${user.serviceInfo}</textarea>
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputPassword">地址</label>
    <div class="controls">
      <input type="text" name="homeAddress" value="${user.homeAddress}">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputPassword">电话</label>
    <div class="controls">
      <input type="text" name="phoneNum" value="${user.phoneNum}">
    </div>
  </div>
	<div class="control-group">
    <label class="control-label" for="inputPassword">邮箱</label>
    <div class="controls">
      <input type="text" name="emailAddress" value="${user.emailAddress}">
    </div>
  </div>
  
  <div class="control-group">
    <label class="control-label" for="inputPassword">QQ</label>
    <div class="controls">
      <input type="text" name="qqNum" value="${user.qqNum}">
    </div>
  </div>
  
  <legend>App基本属性</legend>
  <div class="control-group">
    <label class="control-label" for="inputPassword">App名字</label>
    <div class="controls">
      <input type="text" name="siteName" value="${user.siteName}">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputPassword">LOGO</label>
    <div class="controls">
      <input type="file" name="imgFile">
    </div>
  </div>
  <div class="control-group">
  	<img alt="" src="${user.logoPath}">
  </div>
  </div>
  <div class="control-group">
  		<input type="submit" value="更新" class="btn">
  </div>
</fieldset>
  
</form>

</div>