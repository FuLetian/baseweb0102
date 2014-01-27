<!-- 
当前页面
a:html/page2-brandId- -channelId- -menuId- -priceRange- -discountRange- .html
 -->

<!-- location -->
<div class="location container">您现在的位置:</div>
<!-- //location -->

<!-- selector -->
<div class="container">
<div class="selector">
<div class="row">
	<div class="col-xs-1"><b>商&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;家</b></div>
	<div class="col-xs-11">
		<ul class="list-inline">
		  <li>...</li>
		  <li>...</li>
		  <li>...</li>
		  <li>...</li>
		  <li>...</li>
		  <li>...</li>
		</ul>
	</div>
</div>
<div class="row">
	<div class="col-xs-1"><b>价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格</b></div>
	<div class="col-xs-11">
		<ul class="list-inline">
		  <li><a href="">0-10元</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		  <li><a href="#">10-15元</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		  <li><a href="#">15-20元</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		  <li><a href="#">20-25元</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		  <li><a href="#">25元以上</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		</ul>
	</div>
</div>
<div class="row">
	<div class="col-xs-1"><b>折&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;扣</b></div>
	<div class="col-xs-11">
		<ul class="list-inline">
		  <li><a href="#">1/2折</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		  <li><a href="#">3/4折</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		  <li><a href="#">5/6折</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		  <li><a href="#">7/8折</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		  <li><a href="#">9/10折</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		</ul>
	</div>
</div>
</div>
</div>
<!-- //selector -->

<!-- articles -->
<div class="container">
<div class="bar-sort">
	<div class="btn-sort btn-sort-active-default"><label>默认排序</label><span class="glyphicon glyphicon-align-center"></span></div>
	<div class="btn-sort"><label>销量降序</label><span class="glyphicon glyphicon-arrow-down"></span></div>
	<div class="btn-sort"><label>价格升序</label><span class="glyphicon glyphicon-arrow-up"></span></div>
	<div class="btn-sort"><label>折扣升序</label><span class="glyphicon glyphicon-arrow-up"></span></div>
</div>
<div class="row">

<#list articles as item>
  <div class="col-xs-3">
    <div class="thumbnail">
      <img src="../images/cell.jpg" alt="...">
      <div class="caption">
        <h3>覆盖</h3>
        <p>5</p>
        <p><button class="btn btn-primary addToBuyCar" role="button">加入购物车</button> 
        	<a href="${global_local_domain}html/page2-brandId-${item.brandId}-channelId-${item.channelId}-menuId-${item.menuId}-priceRange--discountRange-.html" class="btn btn-default" role="button">购买</a></p>
      </div>
    </div>
  </div>
</#list>

</div>
</div>
<!-- //articles -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">您已将[<span class="articleName"></span>]加入购物车</h4>
      </div>
      <div class="modal-body">
        <dl class="dl-horizontal">
		  <dt>...</dt>
		  <dd>...</dd>
		</dl>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
