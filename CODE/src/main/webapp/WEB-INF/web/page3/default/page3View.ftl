<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page3</title>

<#include "/common/resources.ftl"/>

<script>
var global_server_domain="${global_server_domain}";
</script>

</head>
<body>
<#include MenuView/>
<div class="container">
	<div class="row">
		<div class="col-xs-12 margin-top-line" style="font-size:12px;height:40px;">
				<ol class="breadcrumb">
				  <li>Bootstrap</li>
				  <li class="active">服务与保障</li>
				</ol>			
		</div>
	</div>
	<div class="row">
		<div class="col-xs-2">
			<#include LeftNavigationView/>
		</div>
		<div class="col-xs-10"><#include MainPassageView/></div>
	</div>
</div>

<#include FooterView/>
</body>
</html>