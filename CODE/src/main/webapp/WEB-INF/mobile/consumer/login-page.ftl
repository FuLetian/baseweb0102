<div data-role="page">
<script type="text/javascript">
function login2(){
	$("#loginForm2").ajaxSubmit({
		dataType:"json",
		success:function(data){
			if(data.result){
				$.cookie('key_session_consumer_id',data.consumerId, { expires: 7, path: '/' });
				var t="${targetUrl}".replace("_","&");
				changePage(t);
			}else{
				alert("账户或密码错误!");
			}
		}
	});
	
	return false;
}
</script>

	<div data-role="header">
		<a data-rel="back" data-icon="back">back</a>
		<h1>商品列表</h1>
	</div><!-- /header -->
	
	<div data-role="content"> 
   		<form id="loginForm2" action="${basePath}mobile-consumer/login" method="POST">
   			<input type="hidden" name="userId" value="${userId}">
			<input type="text" name="account" placeHolder="email/账户名"/>
   			<input type="password" name="pwd" placeHolder="密码"/>
   		</form>
   		<button class="button" onclick="login2();">登陆</button>
	</div><!-- /content -->
	
<#include "/mobile/common/footer.ftl"/>	
</div>