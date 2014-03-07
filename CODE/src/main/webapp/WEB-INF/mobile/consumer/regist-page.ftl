<div id="registerPage" data-role="page">

		<script type="text/javascript">
			function regist(){
				alert(1);
				var value=$("#form").ajaxSubmit({
					url:'${basePath}mobile-consumer/onRegist',
					dataType:"json",
					success:function(data){
						if(data.code==1){
							alert("用户名已存在");
						}else if(data.code==2){
							alert("邮箱已存在");
						}else{
							alert("注册成功");
							changePage("${basePath}mobile-homepage/view?userId=${userId}");
						}
					}
				});

			};
		</script>
		<style type="text/css">
			#container{
				background-color:#F0F0F0;
				border:1px solid #BBBBBB;
			}
			.table{
				width:100%;
			}
			
			.table input{width:90%;margin-left:5%;}
		</style>
		
	<div data-role="header" data-theme="c">
		<a href="#" data-rel="back" data-theme="b" data-corners="false">完成</a>
		<h3>注册</h3>
	</div>
	
<form id="form" action="${basePath}mobile-consumer/onRegist">
<div id="container">
<table class="table">
	<tr>
		<td style="width:30%;">账户名:</td>
		<td><input type="text" name="account" holdPlace="账户名"></td>
	</tr>
	<tr>
		<td>邮箱:</td>
		<td><input type="text" name="emailAddress"></td>
	</tr>
	<tr>
		<td>密码:</td>
		<td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<td>确认密码:</td>
		<td><input type="password" name="pwd2"></td>
	</tr>
	<tr>
		<td>昵称:</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>地址:</td>
		<td><input type="text" name="address"></td>
	</tr>
	<tr>
		<td>电话号码:</td>
		<td><input type="text" name="phoneNum"></td>
	</tr>
	<tr>
		<td>头像:</td>
		<td><input type="file" name="imgFile"></td>
	</tr>
</table>
</div>
<input type="hidden" name="userId" value="${userId}">
</form>
<div onclick="regist()" style="height:50px;font-size:20px;color:red;text-align">提交信息</div>
	
	<#include "/mobile/common/footer.ftl"/>	
</div>