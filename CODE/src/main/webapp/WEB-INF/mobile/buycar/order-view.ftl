<div id="orderView" data-role="page">
	<div data-role="header" data-theme="c">
		<a data-rel="back" data-icon="back" data-corners="false" data-theme="b" >返回</a>
		<h1>结算</h1>
	</div>
	
	<div data-role="content">
		
		<#if loginConsumer?if_exists>
		<#else>
		<div>
			<a href="${basePath}/mobile-consumer/login-view?userId=${userId}" type="button" data-rel="dialog"  data-transition="pop">登陆享受更多优惠哟</a>
		</div>
		</#if>

		<form id="orderForm" action="${basePath}mobile-buycar/addOrder">
		<input id="hiddenCID" type="hidden" name="cId" value="0">
		<input type="hidden" name="userId" value="${userId}">
		<div class="ui-shadow" style="border:1px solid #588EBD;padding:10px 10px 10px 10px;">
		<table style="width:100%;font-size:14px;">
			<tr>
				<td style="width:20%;">姓名:</td>
				<td><input type="text" name="name" value="${loginConsumer.name}"/></td>
			</tr>
			<tr>
				<td style="width:20%;">Email:</td>
				<td><input type="email" name="email" value="${loginConsumer.email}"/></td>
			</tr>
			<tr>
				<td style="width:20%;">电话:</td>
				<td><input type="number" name="phone" value="${loginConsumer.phoneNum}"/></td>
			</tr>
			<tr>
				<td style="width:20%;">地址:</td>
				<td><input type="text" name="address" value="${loginConsumer.address}"/></td>
			</tr>
			<tr>
				<td style="width:20%;">备注:</td>
				<td><textarea name="remark"></textarea></td>
			</tr>
		</table>
		</div>
		<div align="left" style="font-size:15px;color:red;font-weight:bold;margin-top:20px;">总计:￥${moneyTotal}</div>
		<div><button data-theme="b" data-corners="false" onclick="sumbitOrder(${userId});return false;">提交订单</button></div>
		</form>
		
	</div>
	
	<#include "/mobile/common/footer.ftl"/>	
	
	<script type="text/javascript">
		function sumbitOrder(userId){
			var cId=getLoginConsumerId();
			$("#hiddenCID").val(cId);
			$("#orderForm").ajaxSubmit({
				dataType:"json",
				success:function(data){
					
					if(data.result){
						$.mobile.changePage(basePath+"mobile-buycar/order-success?userId="+userId);
					}
					
				}
			});
			
		}
	</script>
</div>