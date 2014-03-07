	<div data-role="footer" data-position="fixed" data-theme="c">
		<div data-role="navbar" data-theme="b">
		    <ul>
		        <li><a href="${basePath}mobile-homepage/view" data-icon="home">主页</a></li>
		        <li><a href="${basePath}mobile-menu/view?userId=${userId}" data-icon="bullets">频道</a></li>
		        <li><a href="${basePath}mobile-buycar/view?userId=${userId}" data-icon="star">购物车</a></li>
		        <li><a href="#" data-icon="gear" onclick="toSettingPage();">设置</a></li>
		    </ul>
		</div>
	</div>
	<script>
		function toSettingPage(){
			var cId=getLoginConsumerId();
			changePage("${basePath}mobile-setting/view?userId=${userId}&cId="+cId);
		}
	</script>