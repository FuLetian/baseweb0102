<h3>channelView</h3>
<#list channels as item>
<a href="${basePath}/page1/view?channelId=${item.id}">${item.name}</a>,
</#list>