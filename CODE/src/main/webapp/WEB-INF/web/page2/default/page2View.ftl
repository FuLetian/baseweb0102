<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page2</title>

<#include "/common/resources.ftl"/>
<script>
var global_server_domain="${global_server_domain}";
var global_local_domain="${global_local_domain}";
var page2_menu_id=${param_menu_id};
</script>

</head>
<body>
<#include MenuView/>
<#include ArticleInPage2View/>
<#include FooterView/>
</body>
</html>