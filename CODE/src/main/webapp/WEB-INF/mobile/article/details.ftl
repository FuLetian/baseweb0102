<div data-role="page">

<style>
.article-details-buy{background-color:#FFFFFF;margin-top:10px;margin-bottom:10px;padding:10px 10px 10px 10px;}
</style>

	<div data-role="header" data-position="fixed" data-theme="c">
		<a data-rel="back" data-icon="back">返回</a>
		<h1>详细信息</h1>
	</div><!-- /header -->
	
	<div class="ui-shadow">

		<div style="height:40px;line-height:40px;background-color:#ED145B;color:#FFFFFF;text-align:center;font-size:20px;">${article.name}</div>
		<div style="padding-top:5px;padding-bottom:5px;;background-color:#8E8C7F;" align="left">
			<img src="${basePath}h/images/star.png" style="height:50%;" />
			<img src="${basePath}h/images/star.png" style="height:50%;" />
			<img src="${basePath}h/images/star.png" style="height:50%;" />
			<img src="${basePath}h/images/star.png" style="height:50%;" />
			<img src="${basePath}h/images/star.png" style="height:50%;" />
		</div>
		<div style="height:30px;line-height:30px;">
			销量:${article.saleCount}
			<span style="margin-left:10px;border-left:1px solid #999999;padding-left:10px;">更新日期:${article.uDt?string("yyyy/MM/dd")}</span>
		</div>
	</div>
	
	<div>
	<div class="ui-shadow" style="margin-top:10px;">
		<div>
			<img src="${article.homepageImg}" class="util-img-equals-width"/>
		</div>
		
		<div class="ui-grid-b" style="margin-top:5px;padding-bottom:5px;color:#888888;">
			<div class="ui-block-a">
		    	<div style="height:30px" align="center">
		    		<a href="#"  onclick="clip(${article.id});"><img src="${basePath}h/images/heart.png" style="height:70%;" /></a>${article.clipCount}</div>
		    </div>
		    <div class="ui-block-b">
		    	<div style="height:30px" align="center"><img src="${basePath}h/images/msg.png" style="height:70%;" />${commentSize}</div>
		    </div>
		    <div class="ui-block-c" onclick="collect(${article.id},${userId})">
		    	<div style="height:30px" align="center">
		    		<a href="#"><img src="${basePath}h/images/add.png" style="height:70%;" /></a>${collections}</div>
		    </div>
		</div><!-- /grid-c -->
	</div>
		
		<div class="article-details-buy ui-shadow">
			<table style="font-size:12px;width:100%;text-align:left;">
				<tr>
					<td>价&nbsp;&nbsp;格</td>
					<td>${article.price}</td>
				</tr>
				<tr>
					<td>数&nbsp;&nbsp;量</td>
					<td>
						<table>
							<tr>
								<td><a href="#" data-role="button" data-icon="minus" data-iconpos="notext" data-theme="c" data-inline="true" onclick="minusCount();">Plus</a></td>
								<td><input type="number" id="countInput" value="1"></td>
								<td><a href="#" data-role="button" data-icon="plus" data-iconpos="notext" data-theme="c" data-inline="true" onclick="plusCount();">Minus</a></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan=2 align="right">
						<a href="#" data-role="button" data-mini="true" data-inline="true" data-icon="star" data-theme="b" onclick="addToBuycar(${article.id});">加入购物车</a>
					</td>
				</tr>
			</table>
		</div>
		
		<div data-role="tabs" id="tabs">
		  <div data-role="navbar">
		    <ul>
		      <li><a href="#" data-ajax="false" onclick="listDetailsInfo();" class="ui-btn-active">详细介绍</a></li>
		      <li><a href="#" data-ajax="false" onclick="listComments(${userId},${article.id})">评论列表</a></li>
		    </ul>
		  </div>
		  <div id="tabsContent-comments"></div>
		  <div id="tabsContent-info" class="ui-body-d ui-content">
		  	<div style="border-bottom:1px dashed #666666;padding-bottom:5px;font-size:12px;">※商品属性</div>
		  	<#list props as p>
		  		<p class="util-text-popular util-text-indent">${p.name}&nbsp;:&nbsp;${p.value}</p>
		  	</#list>
		  	<div style="border-bottom:1px dashed #666666;padding-bottom:5px;font-size:12px;">※商品描述</div>
			<p class="util-text-popular util-text-indent">${article.remark}</p>
			<#list imgs as i>
				<div><img src="${basePath}${i.path}" class="util-img-equals-width"/></div>	
			</#list>	  	
		  </div>
		</div>

	</div><!-- /content -->
	
<#include "/mobile/common/footer.ftl"/>
<script type="text/javascript">
function clip(articleId){
	$.getJSON(basePath+"mobile-article/clip",{"articleId":articleId},function(data){
		if(data.result){
			alert("点赞成功");
		}else{
			alert("请不要频繁的点赞");
		}
	});
}

function collect(articleId,userId){
	var cId=getLoginConsumerId();
	if(cId==0){
		if(confirm("会员才能发表评论，跳转至登陆页面吗?")){
			changePage(basePath+"mobile-consumer/login-page?userId="+userId+"&targetUrl=${basePath}mobile-article/details?userId="+userId+"_articleId="+articleId);
		}
	}else{
		$.getJSON(basePath+"mobile-article/collect",{"articleId":articleId,"consumerId":cId,"runStatus":4},function(data){
			if(data.result){
				alert("已收藏");
			}else{
				alert("已经在您的收藏夹里");
			}
		});
	}
}
</script>
	
</div><!-- /homepage -->