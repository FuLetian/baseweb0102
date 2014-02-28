<div id="menuPage" data-role="page">

	<div data-role="header">
		<a data-rel="back" data-icon="back">back</a>
		<h1>二级菜单</h1>
	</div><!-- /header -->
	
	<div data-role="content"> 

	<ul data-role="listview" data-inset="true">
		<#list menus as item>
            <li><a href="${basePath}mobile-article/view?userId=${userId}&menuId=${item.id}">
                <img src="${basePath}h/images/apple.png" class="ui-li-thumb">
                <h2>${item.name}</h2>
                <p>Apple released iOS 6.1</p>
                <p class="ui-li-aside">iOS</p>
            </a></li>
        </#list>
   </ul>
        
	</div><!-- /content -->
	
	<#include "/mobile/common/footer.ftl"/>	
	
</div>