<div data-role="page">

	<div data-role="header">
		<a data-rel="back" data-icon="back">返回</a>
		<h1>人气商品</h1>
	</div><!-- /header -->
	
	<div> 

		<ul data-role="listview" data-inset="true">
			<#list articles as item>
	            <li><a href="${basePath}mobile-article/details?userId=${userId}&articleId=${item.id}">
	                <img src="${basePath}h/images/apple.png" class="ui-li-thumb">
	                <h2>${item.name}</h2>
	                <p>${item.remark}</p>
	            </a></li>
	        </#list>
	   </ul>
   
	</div><!-- /content -->
	
<#include "/mobile/common/footer.ftl"/>	