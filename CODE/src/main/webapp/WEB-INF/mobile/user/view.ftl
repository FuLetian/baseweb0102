<div data-role="page">

	<div data-role="header" data-position="fixed" data-theme="c">
		<a data-rel="back" data-theme="b" data-corners="false">完成</a>
		<h1>关于我们</h1>
	</div>
	
	<div> 
		<div style="background-color:#C9C9C1;color:#71726C;font-size:16px;height:30px;line-height:30px;font-weight:bold;">基本信息</div>
   		<div style="background-color:#EEEEE2;color:#333333;text-indent:2em;padding:20px 0px 20px 0px;">
   			${user.basicInfo}
   		</div>
	</div>
	<div> 
		<div style="background-color:#C9C9C1;color:#71726C;font-size:16px;height:30px;line-height:30px;font-weight:bold;">服务理念</div>
   		<div style="background-color:#EEEEE2;color:#333333;text-indent:2em;padding:20px 0px 20px 0px;">
   			${user.serviceInfo}
   		</div>
	</div>
	<div> 
		<div style="background-color:#C9C9C1;color:#71726C;font-size:16px;height:30px;line-height:30px;font-weight:bold;">联系方式</div>
   		<div style="background-color:#EEEEE2;color:#333333;text-indent:2em;padding:20px 0px 20px 0px;font-size:16px;">
   			<div><b>地址:</b>${user.homeAddress}</div>
   			<div style="margin-top:10px;"><b>电话号码:</b>${user.phoneNum}</div>
   			<div style="margin-top:10px;"><b>QQ:</b>${user.qqNum}</div>
   			<div style="margin-top:10px;"><b>邮箱:</b>${user.emailAddress}</div>
   		</div>
	</div>
	<div> 
		<div style="background-color:#C9C9C1;color:#71726C;font-size:16px;height:30px;line-height:30px;font-weight:bold;">给我们留言</div>
   		<div style="background-color:#EEEEE2;color:#333333;">
   			<textarea rows="" cols="" data-corners="false" data-clear-btn="true"></textarea>
   			<button data-theme="b" data-corners="false">提交</button>
   		</div>
	</div>
<#include "/mobile/common/footer.ftl"/>	