<div id="menuPage" data-role="page">

	<div data-role="header" data-position="fixed" data-theme="b">
		<a data-rel="back" data-icon="back">back</a>
		<h1>一级菜单</h1>
	</div><!-- /header -->
	
	<div data-role="content"> 
	<#list menus as item1>
	<div style="border-bottom:1px dashed #999999;padding-bottom:10px;">
		<div style="color:black;font-weight:bold;padding:10px 0px 10px 0px;margin-right:10px;">${item1.menu.name}</div>
		<div>
		<#list item1.childMenus as item2>
			<span style="border-right:1px solid #999999;padding:0px 10px 0px 10px;"><a href="${basePath}mobile-article/view?userId=${userId}&menuId=${item2.menu.id}">${item2.menu.name}</a></span>
		</#list>	
		</div>
	</div>
    </#list>
    
	</div><!-- /content -->
	
	<#include "/mobile/common/footer.ftl"/>	
	
</div>