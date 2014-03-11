<div data-role="page">
<script>
function onStarPrompt(orderId){
	var str=prompt("请输入评分[0-5]","5");
	if(str){
		var reg = new RegExp("^[0-9]*$");
		if(!reg.test(str)){
			alert("请输入数字");
		}else{
			if(parseInt(str)<0||parseInt(str)>5){
				alert("输入值介于[0-5]之间");
			}else{
				$.post("${basePath}mobile-order/set-star",{"star":str,"userId":${userId},"orderId":orderId},function(data){
					alert("打分成功");
					$("#starP").text(str);
				});
			}
		}
	}
};

function onCommentPrompt(orderId){
	var str=prompt("请输入评论内容","");
	if(str){
		//同步服务器
		var cId=getLoginConsumerId();
		$.post("${basePath}mobile-order/set-comment",{"articleId":${orderArticle.article.id},"orderId":orderId,"cId":cId,"userId":${userId},"comment":str},function(data){
			alert("评论成功");
			$("#commentP").text(str);
		});
	}
}
</script>

<div data-role="header" data-theme="c">
	<a href="#" data-rel="back" data-theme="b" data-corners="false">返回</a>
	<h3>订单详情</h3>
</div>
<div><img alt="" src="${orderArticle.article.homepageImg}" style="width:100%;"></div>
<div style="padding:0px 15px 5px 15px;">
	<p><a href="${basePath}mobile-article/details?userId=${userId}&articleId=${orderArticle.article.id}" style="TEXT-DECORATION:none;font-size:16px;font-weight:bold;color:000000;">${orderArticle.article.name}</a></p>
</div>
<div style="height:30px;line-height:30px;background-color:#C9C9C1;"><b>&nbsp;&nbsp;基本信息</b></div>
<div style="padding:0px 15px 5px 15px;">
	<p><b>时间:</b>${orderArticle.order.cDt?string("yyyy-MM-dd HH:mm")}</p>
	<p><b>数量:${orderArticle.order.count}</b></p>
	<p><b>状态:</b>
		<#if orderArticle.order.runStatus==0>
			已下单未处理
		<#elseif orderArticle.order.runStatus==1>
			正在处理订单
		<#elseif orderArticle.order.runStatus==2>
			已发货，正在配送
		<#elseif orderArticle.order.runStatus==3>
			已签收，交易结束
		<#elseif orderArticle.order.runStatus==4>
			收藏夹
		<#else>
			未知状态
		</#if>
	</p>
</div>
<div style="height:30px;line-height:30px;background-color:#C9C9C1;"><b>&nbsp;&nbsp;收货人信息</b></div>
<div style="padding:0px 15px 5px 15px;">
	<p><b>姓名:</b>${orderArticle.order.tourName}</p>
	<p><b>电话:</b>${orderArticle.order.tourPhone}</p>
	<p><b>地址:</b>${orderArticle.order.tourAddress}</p>
	<p><b>备注:</b>${orderArticle.order.remark}</p>
</div>
<div style="height:30px;line-height:30px;background-color:#C9C9C1;"><b>&nbsp;&nbsp;我的评论</b></div>

<div style="padding:0px 15px 5px 15px;">
<p><b>分数</b>
	<span id="starP">${orderArticle.comment.grade}</span>
</p>
<p>
	<b>内容:</b>
	<span id="commentP">${orderArticle.comment.content}</span>
</p>
</div>

<div style="padding:0px 15px 5px 15px;">
	<table style="width:100%;">
		<tr>
			<td ><button class="button" data-inset="true" data-corners="false" onclick="onStarPrompt(${orderArticle.order.id});">打分</button></td>
			<td ><button class="button" data-inset="true" data-corners="false" onclick="onCommentPrompt(${orderArticle.order.id});">评论</button></td>
		</tr>
	</table>
</div>
<#if orderArticle.order.runStatus==4>
<div style="height:30px;line-height:30px;background-color:#C9C9C1;"><b>&nbsp;</b></div>
<div style="padding:0px 15px 5px 15px;">
<button class="button" data-corners="false" data-theme="b" onclick="changePage('${basePath}mobile-article/details?userId=${userId}&articleId=${orderArticle.article.id}');">前去购买</button>
</div>
</#if>

<#include "/mobile/common/footer.ftl"/>	
</div>