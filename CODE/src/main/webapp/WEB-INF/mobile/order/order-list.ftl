<div data-role="page">
<script>
function toOrderDetailsPage(orderId){
	var cId=getLoginConsumerId();
	changePage("${basePath}mobile-order/details?userId=${userId}&orderId="+orderId+"&cId="+cId);
}
</script>
	<div data-role="header" data-theme="c">
		<a data-rel="back" data-theme="b" data-corners="false">完成</a>
		<h1>飞蛾</h1>
	</div><!-- /header -->
	
	<div> 

		<ul data-role="listview" data-inset="false" data-theme="c">
			<#list list as item>
		    <li><a onclick="toOrderDetailsPage(${item.order.id});" href="#">
		        <h2>${item.article.name}</h2>
		        <p>${item.order.remark}</p>
		        <p class="ui-li-aside"><strong>${item.order.uDt?string("yyyy-MM-dd HH:mm")}</strong>PM</p>
		    </a></li>
			</#list>
		</ul>

	</div><!-- /content -->
	
<#include "/mobile/common/footer.ftl"/>	
</div>