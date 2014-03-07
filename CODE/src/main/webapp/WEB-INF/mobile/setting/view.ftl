<div data-role="page">
	<div data-role="header" data-theme="c">
		<h3>设置</h3>
		<a href="#" data-rel="back" data-icon="check" data-theme="b" data-corners="false">完成</a>
	</div>
	
	<div style="width:90%;margin-left:5%;">

<div class="shadow">
<ul data-role="listview" style="margin-top:10px;" data-inset="false">
    <li><a href="#">将应用添加至桌面</a></li>
</ul>
</div>

<div class="shadow">
<ul data-role="listview" style="margin-top:10px;" data-inset="false">
    <li><a href="#">服务条款</a></li>
    <li><a href="#">版本信息</a></li>
</ul>
</div>

<#if cId==0>
<div class="shadow">
<ul data-role="listview" style="margin-top:10px;" data-inset="false">
    <li><a href="${basePath}mobile-consumer/login-page?userId=${userId}&targetUrl=${basePath}mobile-setting/view?userId=${userId}">登陆获取更多服务</a></li>
</ul>
</div>
<#else>
<div class="shadow">
<ul data-role="listview" style="margin-top:10px;" data-inset="false">
    <li><a href="#">更改账户资料</a></li>
    <li><a href="#signoutDialog" data-rel="popup" data-position-to="window" data-transition="pop">注销</a></li>
</ul>
</div>
</#if>

	</div>
	
	<#include "/mobile/common/footer.ftl"/>	
	
<style>
.shadow{
	filter:progid:DXImageTransform.Microsoft.Shadow(color=#909090,direction=120,strength=4);
				-moz-box-shadow: 2px 2px 10px #909090;
				-webkit-box-shadow: 2px 2px 10px #909090;
				box-shadow:2px 2px 10px #909090;
}
</style>
<script type="text/javascript">
function signout(){
	$.cookie('key_session_consumer_id', null,{ expires: -1,path:"/" });
	changePage("${basePath}mobile-setting/view?userId=${userId}&cId=0");
}
</script>
<div data-role="popup" id="signoutDialog" data-theme="d" data-overlay-theme="b" data-inset="false" class="ui-content" style="max-width:340px; padding-bottom:2em;">
    <h3>您确定要注销账户吗?</h3>
    <p>登陆会员可享受更多服务,我们真诚邀请您保持登陆状态.</p>
    <a href="#" data-role="button" data-theme="b" data-inline="true" data-mini="true" data-corners="false" onclick="signout();">注销</a>
    <a href="#" data-role="button" data-rel="back" data-inline="true" data-mini="true" data-corners="false">取消</a>
</div>
</div>