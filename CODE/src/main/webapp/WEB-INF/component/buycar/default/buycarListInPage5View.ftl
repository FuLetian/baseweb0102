<div style="margin-top:15px;border-bottom:1px dashed #CCCCCC;height:50px;">
	<div style="float:left;width:100px;"><h4>购物车</h4></div>
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

<div style="margin-top:15px;border-bottom:1px dashed #CCCCCC;height:50px;">
	<div style="float:left;width:100px;"><h4>收货信息</h4></div>
</div>

<div style="width:70%;" class="margin-top-line">
<form class="form-horizontal" role="form">

  <div class="form-group">
    <label for="i1" class="col-sm-2 control-label">姓名:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="i1" data-bind="value:consumerOrderInfo().name">
    </div>
  </div>
  <div class="form-group">
    <label for="i2" class="col-sm-2 control-label">地址:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="i2" data-bind="value:consumerOrderInfo().address">
    </div>
  </div>
  
    <div class="form-group">
    <label for="i2" class="col-sm-2 control-label">电话:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="i2" data-bind="value:consumerOrderInfo().phoneNum">
    </div>
  </div>
  
    <div class="form-group">
    <label for="i2" class="col-sm-2 control-label">邮件:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="i2" data-bind="value:consumerOrderInfo().email">
    </div>
  </div>
<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">备注</label>
    <div class="col-sm-10">
      <textarea id="remark" class="form-control" rows="3"></textarea>
    </div>
  </div>
  <div class="form-group" data-bind="visible:isConsumer">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox" data-bind="checked:isAutoSetConsumerInfo" value="1"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-8">
    	<button type="submit" class="btn btn-danger btn-block" data-bind="click:onSaveOrder">提交订单</button>
    </div>
    <div class="col-sm-2">
    	 <button data-bind="visible:isTourist,click:openLoginModal" type="button" class="btn btn-default">登陆可享受积分</button>
    </div>
  </div>
</form>
</div>

<!-- Modal -->
<div class="modal fade" id="saveOrderSuccessModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        您已成功提交订单!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="location.reload();">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->