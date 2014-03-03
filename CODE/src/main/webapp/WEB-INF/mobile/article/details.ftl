<!-- homepage -->
<div data-role="page">
<div data-role="popup" id="purchase" data-theme="d" data-overlay-theme="b" class="ui-content" style="max-width:340px; padding-bottom:2em;">
    <h3>Purchase Album?</h3>
    <p>Your download will begin immediately on your mobile device when you purchase.</p>
    <a href="index.html" data-role="button" data-rel="back" data-theme="b" data-icon="check" data-inline="true" data-mini="true">Buy: $10.99</a>
    <a href="index.html" data-role="button" data-rel="back" data-inline="true" data-mini="true">Cancel</a>
</div>

<style>
.article-details-buy{background-color:#FFFFFF;margin-top:10px;margin-bottom:10px;padding:10px 10px 10px 10px;border:1px solid #3388CC;}
</style>

	<div data-role="header">
		<a data-rel="back" data-icon="back">back</a>
		<h1>${article.name}</h1>
	</div><!-- /header -->
	
	<div data-role="content"> 
		<div>
			<img src="${basePath}h/images/big-article.jpg" class="util-img-equals-width"/>
		</div>
		
		<div class="article-details-buy ui-corner-all ui-shadow">
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
	
</div><!-- /homepage -->