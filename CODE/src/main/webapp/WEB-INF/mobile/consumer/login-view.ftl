<div id="loginPage" data-role="page" data-close-btn="right">
	<div data-role="header" style="height:40px;" ><h1>用户登陆</h1></div>
	<div data-role="content">
		<form id="loginForm" action="${basePath}mobile-consumer/login" method="POST">
		<input type="hidden" name="userId" value="${userId}">
		<table style="width:100%;font-size:18px;">
			<tr>
				<td style="width:20%;">姓名:</td>
				<td><input type="text" name="account"/></td>
			</tr>
			<tr>
				<td style="width:20%;">密码:</td>
				<td><input type="password" name="pwd"/></td>
			</tr>
		</table>
		<a href="#" onclick="login()">登陆</a>
		</form>
	</div>
<script type="text/javascript">
	function initFormIfLogined(consumerId){
		$.getJSON(basePath+"consumerITF/getLoginConsumerInfo",{"consumerId":consumerId},function(data){
			console.log(data);
		});
	}
	
	$(function(){
		//initFormIfLogined();
	});
</script>
</div>