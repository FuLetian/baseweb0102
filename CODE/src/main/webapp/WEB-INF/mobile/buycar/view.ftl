<div id="buycarPage" data-role="page">
	<div data-role="header" data-theme="b">
		<a data-rel="back" data-icon="back">back</a>
		<h1>购物车列表</h1>
	</div>
	
	<div data-role="content">
	
		<div id="articleList">

		<div style="background-color:#FFFFFF;padding:10px 5px 10px 5px;" class="ui-corner-all ui-shadow">
		
			<#list list as item>
			<div id="buycar-item-${item.article.id}" style="border-bottom:1px solid #EAE3DD;">
			<table style="width:100%;">
				<tr>
					<td style="width:20%;">
						<img src="${item.article.homepageImg}" class="util-img-equals-width" onclick="changePage('${basePath}mobile-article/details?articleId=${item.article.id}&userId=${userId}');" />
					</td>
					<td valign="top" style="padding:5px 5px 5px 5px;">
						<div style="height:30px;line-height:30px;border-bottom:1px dashed #999999;" onclick="changePage('${basePath}mobile-article/details?articleId=${item.article.id}&userId=${userId}');">
							<span><b>${item.article.name}</b></span>
						</div>
						<div style="margin-top:10px;">
							<span style="color:#666666;">数量:${item.count}</span>
							<span style="color:#BA0068;float:right;">小计:￥<label class="moneyItem">${item.article.price*item.count}</label></span>
						</div>
					</td>
					<td style="width:20%;background-color:red;color:#FFFFFF;text-align:center;" onclick="removeBuycarItem(${item.article.id})">删除</td>
				</tr>
			</table>
			</div>
			</#list>
		</div>
		
		<div style="height:50px;line-height:50px;font-weight:bold;text-align:left;font-size:16px;color:red;">合计:￥<span id="meneyTotal"></span></div>
		<div><a href="#" type="button" data-theme="b" onclick="toOrderView();">结算</a></div>
		
		</div>
		
		<div id="nothingContent">您的购物车还是空的哟!</div>
	</div>
	
	<#include "/mobile/common/footer.ftl"/>	
	<script type="text/javascript">
		$(function(){
			totalMoneyItem();
		});
		
		function toOrderView(){
			$.mobile.changePage("${basePath}mobile-buycar/orderView?userId=${userId}&cId="+getLoginConsumerId()+"&moneyTotal="+$("#meneyTotal").text());
		}
	</script>
</div>