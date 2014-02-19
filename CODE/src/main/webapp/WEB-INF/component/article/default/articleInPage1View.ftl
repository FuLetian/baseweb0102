<!--
商品详情界面
a:html/page2-articleId-${articleId}
-->
<#macro getStars grade>

<#if test="${0<grade}">
<span class="glyphicon glyphicon-star-empty"></span>
<#else>
<span class="glyphicon glyphicon-star"></span>
</#if>
<#if test="${1<grade}">
<span class="glyphicon glyphicon-star-empty"></span>
<#else>
<span class="glyphicon glyphicon-star"></span>
</#if>
<#if test="${2<grade}">
<span class="glyphicon glyphicon-star-empty"></span>
<#else>
<span class="glyphicon glyphicon-star"></span>
</#if>
<#if test="${3<grade}">
<span class="glyphicon glyphicon-star-empty"></span>
<#else>
<span class="glyphicon glyphicon-star"></span>
</#if>
<#if test="${4<grade}">
<span class="glyphicon glyphicon-star-empty"></span>
<#else>
<span class="glyphicon glyphicon-star"></span>
</#if>

</#macro>
<div class="col-xs-8">
	<div class="subject-text1"></div>
	<#list articles as item>
	<div>
		<a href="page4-articleId-${item.id}.html" class="thumbnail">
		<div class="row">
			<div class="col-xs-3" style="padding:20px 10px 0px 10px;color:#E3007F;">
				<div style="margin-left:10%;">
					<blockquote>
						<p>规格规格</p>
						<div style="border:1px dashed red;">
						<div style="font-size:12px;"><@getStars grade=item.stars/></div>
						<small><em>总销量:${item.saleCount}</em></small>
						</div>
					</blockquote>
				</div>
				<div style="color:#3e3e3e;margin-left:20px;border-top:1px dashed red;height:70px;padding-top:10px;">
					<p style="text-indent: 2em">${item.remark}</p>
				</div>

			</div>
			<div class="col-xs-9" style="position:relative;">
				<div><img src="${item.homepageImg}" alt="${item.name}" class="image-equal-width" /></div>
				<div style="float:right;position:absolute;right:15px;bottom:0px;;width:50px;height:20px;background-color:#FFFFFF;color:#F772B5;text-align:center"><em>￥${item.price}</em></div>
			</div>
		</div>
		</a>
	</div>
	</#list>
</div>