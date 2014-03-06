<div id="menuPage" data-role="page">
<style>
.gray{background-color:#DDDDDD;}
.white{background-color:#EEEEEE;}
</style>
	<div data-role="header" data-position="fixed" data-theme="b">
		<a data-rel="back" data-icon="back">back</a>
		<h1>一级菜单</h1>
	</div><!-- /header -->
	
	<div>
	<#assign i=0> 
	<#list menus as item1>
	<#assign i=i+1>
	<div style="padding-bottom:10px;padding-left:5px;;color:#777777;" <#if i%2=0> class="gray"<#else>class="white"</#if>>
		<div style="color:black;font-weight:bold;padding:10px 0px 10px 0px;margin-right:10px;"><a href="#" style="text-decoration:none;">${item1.menu.name}</a></div>
		<div>
		<#list item1.childMenus as item2>
			<span style="padding:0px 10px 0px 10px;height:30px;line-height:30px;"><a href="${basePath}mobile-article/view?userId=${userId}&menuId=${item2.menu.id}" style="text-decoration:none;color:#666666;">${item2.menu.name}</a></span>
		</#list>	
		</div>
	</div>
    </#list>
    
	</div><!-- /content -->
	
	<#include "/mobile/common/footer.ftl"/>	
	
</div>