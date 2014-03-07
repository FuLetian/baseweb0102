<div id="loginPage" data-role="page">
<script type="text/javascript">
function login2(){
	$("#loginForm2").ajaxSubmit({
		dataType:"json",
		success:function(data){
			if(data.result){
				$.cookie('key_session_consumer_id',data.consumerId, { expires: 7, path: '/' });
				var t="${targetUrl}".replace("_","&");
				changePage(t+"&cId="+data.consumerId);
			}else{
				alert("账户或密码错误!");
			}
		}
	});
	
	return false;
}
</script>

	<div data-role="header" data-theme="c">
		<a data-rel="back" data-icon="back" data-theme="b" data-corners="false">完成</a>
		<h3>用户登陆</h3>
	</div><!-- /header -->
	
	<div data-role="content"> 
   		<form id="loginForm2" action="${basePath}mobile-consumer/login" method="POST">
   			<input type="hidden" name="userId" value="${userId}" data-theme="c" data-clear-btn="true">
			<input type="text" name="account" placeHolder="email/账户名"/>
   			<input type="password" name="pwd" placeHolder="密码"/>
   		</form>
   		<button class="button" onclick="login2();" data-corners="false">登陆</button>
   		<div>没有账户?<a href="${basePath}mobile-consumer/regist-page?userId=${userId}">注册</a></div>
	</div><!-- /content -->
	
<#include "/mobile/common/footer.ftl"/>	
</div>