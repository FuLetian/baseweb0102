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
					  <p class="lead">规格规格</p>
					  <p>￥2330.99</p>
					  <p><@getStars grade=3/></p>
					  <small><em>总销量:${item.saleCount}</em></small>
					</blockquote>
				</div>

			</div>
			<div class="col-xs-9">
				<img src="${item.homepageImg}" alt="${item.name}" class="image-equal-width" />
			</div>
		</div>
		</a>
	</div>
	</#list>
</div>