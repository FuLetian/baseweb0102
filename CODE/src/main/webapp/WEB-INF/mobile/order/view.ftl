<div data-role="page">
<script type="text/javascript">
function toOrderListPage(runStatus){
	var cId=getLoginConsumerId();
	changePage("${basePath}mobile-order/order-list?userId=${userId}&cId="+cId+"&runStatus="+runStatus);
}
</script>
	<div data-role="header" data-theme="c">
		<a data-rel="back" data-theme="b" data-corners="false">完成</a>
		<h1>我的订单</h1>
	</div><!-- /header -->
	
	<div> 

		<ul data-role="listview" data-inset="false" data-theme="c">
		    <li><a href="#" onclick="toOrderListPage(2);">
		        <h2>配送中</h2>
		        <p class="ui-li-aside">${postingOrder}件</p>
		    </a></li>
		    <li><a href="#" onclick="toOrderListPage(0);">
		        <h2>已下单，未处理</h2>
		        <p class="ui-li-aside">${makeOrderJustNow}件</p>
		    </a></li>
		    <li><a href="#" onclick="toOrderListPage(1);">
		        <h2>订单正在处理中</h2>
		        <p class="ui-li-aside">${dealingOrder}件</p>
		    </a></li>
		    <li><a href="#" onclick="toOrderListPage(3);">
		        <h2>交易结束</h2>
		        <p class="ui-li-aside">${successedDeal}件</p>
		    </a></li>
		    <li><a href="#" onclick="toOrderListPage(4);">
		        <h2>收藏夹</h2>
		        <p class="ui-li-aside">${collections}件</p>
		    </a></li>
		</ul>

	</div><!-- /content -->
	
<#include "/mobile/common/footer.ftl"/>	
</div>