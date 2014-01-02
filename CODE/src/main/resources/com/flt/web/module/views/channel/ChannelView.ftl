<ul>
<#list channelList as item>
	<li><a href="${basePath}page1/page?channelType=${item.type}">${item.name}</a></li>
</#list>
</ul>