<div id="menuPage" data-role="page">

	<div data-role="header" data-position="fixed" data-theme="b">
		<a data-rel="back" data-icon="back">back</a>
		<h1>一级菜单</h1>
	</div><!-- /header -->
	
	<div data-role="content"> 

<!-- 	<ul data-role="listview" data-inset="true"> -->
<!-- 		<#list rootMenus as item> -->
<!--             <li><a href="${basePath}mobile-menu/secondMenu?rootMenuId=${item.id}&userId=${userId}"> -->
<!--                 <img src="${basePath}h/images/apple.png" class="ui-li-thumb"> -->
<!--                 <h2>${item.name}</h2> -->
<!--                 <p>Apple released iOS 6.1</p> -->
<!--                 <p class="ui-li-aside">iOS</p> -->
<!--             </a></li> -->
<!--         </#list> -->
<!--    </ul> -->

<ul data-role="listview" data-inset="true" data-divider-theme="b">
	<#list menus as item1>
    	<li data-role="list-divider">${item1.menu.name}</li>
    	<#list item1.childMenus as item2>
    		<li><a href="${basePath}mobile-article/view?userId=${userId}&menuId=${item2.menu.id}">${item2.menu.name}</a></li>
    	</#list>
    </#list>

</ul>
        
	</div><!-- /content -->
	
	<#include "/mobile/common/footer.ftl"/>	
	
</div>