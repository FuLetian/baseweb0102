menu
<ul>
	<#list menuList as item1>
	<li>${item1.menu.menuName}</li>
		<#list item1.childMenuList as item2>
			<ul>
				<li>${item2.menu.menuName}</li>
					<ul>
					<#list item2.childMenuList as item3>
						<li>${item3.menu.menuName}</li>
					</#list>
					</ul>
			</ul>
		</#list>
	</#list>
</ul>