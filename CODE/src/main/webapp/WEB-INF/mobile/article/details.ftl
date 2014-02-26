<!-- homepage -->
<div id="homepage" data-role="page">

	<div data-role="header">
		<a data-rel="back" data-icon="back">back</a>
		<h1>${article.name}</h1>
	</div><!-- /header -->
	
	<div data-role="content"> 
		<div>
			<img src="${basePath}h/images/big-article.jpg" class="util-img-equals-width"/>
		</div>
		
		<div data-role="tabs" id="tabs">
		  <div data-role="navbar">
		    <ul>
		      <li><a href="#" data-ajax="false" onclick="listDetailsInfo();">详细介绍</a></li>
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
	
	<div data-role="footer" data-position="fixed">
		<div data-role="navbar">
		    <ul>
		        <li><a href="#" data-icon="home">home</a></li>
		        <li><a href="${basePath}mobile-menu/view?userId=${userId}" data-icon="bullets">menus</a></li>
		        <li><a href="#" data-icon="gear">settings</a></li>
		    </ul>
		</div><!-- /navbar -->
	</div><!-- /footer -->
	
</div><!-- /homepage -->