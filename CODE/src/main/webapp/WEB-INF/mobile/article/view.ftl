
<!-- homepage -->
<div id="homepage" data-role="page">

	<div data-role="header" data-position="fixed" data-theme="c">
		<a data-rel="back" data-icon="back">返回</a>
		<h1>商品列表</h1>
	</div><!-- /header -->
	
	<div> 

		<ul data-role="listview" data-inset="false">
			<#list articles as item>
	            <li><a href="${basePath}mobile-article/details?userId=${userId}&articleId=${item.id}">
	                <img src="${item.homepageImg}" class="ui-li-thumb lazy" style="height:100%;">
	                <h2>${item.name}</h2>
	                <p>Apple released iOS 6.1</p>
	                <p class="ui-li-aside">iOS</p>
	            </a></li>
	        </#list>
	   </ul>
   
	</div><!-- /content -->
	
<#include "/mobile/common/footer.ftl"/>	
<script type="text/javascript">
$(function(){
	$("img.lazy").lazyload();
});
</script>
	
</div><!-- /homepage -->
