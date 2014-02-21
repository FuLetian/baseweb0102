<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page5</title>

<#include "/common/resources.ftl"/>

<script>
var global_server_domain="${global_server_domain}";
var global_local_domain="${global_local_domain}";
</script>

</head>
<body>
	<#include MenuView/>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<#include BuycarListInPage5View/>
			</div>
		</div>
	</div>
	
	<#include FooterView/>
</body>
</html>