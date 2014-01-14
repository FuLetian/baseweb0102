<h3>menuView</h3>
<#list menus as item>
<a href="${basePath}/page1/view?channelId=${item.menu.id}">${item.menu.id}</a>,
</#list>