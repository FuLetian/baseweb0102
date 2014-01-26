<div style="margin-top:15px;border-bottom:1px dashed #CCCCCC;height:50px;">
	<div style="float:left;width:100px;"><h3>购物车</h3></div>
	<div style="margin-left:110px;">syll</div>
</div>
<div class="margin-top-line">
<table class="table table-bordered">
	<tr>
		<th>
			商品
		</th>
		<th>
			价格
		</th>
		<th>
			积分
		</th>
		<th>
			数量
		</th>
		<th>删除</th>
	</tr>
	<tbody data-bind="foreach:selectedArticles">
		<tr>
			<td>
				<div class="media">
				  <a class="pull-left" href="#">
				    <img class="media-object" style="height:50px;" data-bind="attr:{'src':thumbnail}" alt="...">
				  </a>
				  <div class="media-body">
				    <h4 class="media-heading" data-bind="text:article.name">Media heading</h4>
				    ...
				  </div>
				</div>
			</td>
			<td data-bind="text:count*article.price">d</td>
			<td>d</td>
			<td data-bind="text:count">d</td>
			<td>
				<a href="#" data-bind="click:$parent.deleteItem">删除</a>
			</td>
		</tr>
	</tbody>
</table>
</div>