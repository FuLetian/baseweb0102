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
			<div class="col-xs-3 color-pink font-size-12" style="padding:20px 0px 0px 10px;">
				<div style="margin-left:10%;">
					<blockquote>
						<p>规格规格</p>
						<div>
							<div><span class="color-greys">评&nbsp;&nbsp;分:</span><@getStars grade=item.stars/></div>
							<div class="color-greys">销&nbsp;&nbsp;量:${item.saleCount}</div>
							<div class="color-greys">价&nbsp;&nbsp;格:￥${item.price}</div>
						</div>
					</blockquote>
				</div>
				<div style="margin-left:20px;" class="color-greys">
					<p style="text-indent: 2em">${item.remark}</p>
				</div>

			</div>
			<div class="col-xs-9">
				<div><img src="${item.homepageImg}" alt="${item.name}" class="image-equal-width" /></div>
			</div>
		</div>
		</a>
	</div>
	</#list>
</div>