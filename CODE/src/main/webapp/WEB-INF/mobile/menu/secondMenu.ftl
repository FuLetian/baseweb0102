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
	
	<div data-role="footer" data-position="fixed">
		<div data-role="navbar">
		    <ul>
		        <li><a href="#" data-icon="home">home</a></li>
		        <li><a href="${basePath}mobile-menu/view?userId=${userId}" data-icon="bullets">menus</a></li>
		        <li><a href="#" data-icon="gear">settings</a></li>
		    </ul>
		</div><!-- /navbar -->
	</div><!-- /footer -->
	
</div>