<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${basePath}h/javascript/bootstrap/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${basePath}h/javascript/jquery-1.9.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${basePath}h/javascript/bootstrap/js/bootstrap.min.js"></script>

<!--knockout-->
<script src="${basePath}h/javascript/knockout-3.0.0.js"></script>

<!--jquery.form-->
<script src="${basePath}h/javascript/jquery.form.js"></script>

<frameset rows="50,*" cols="*" frameborder="no" border="0" framespacing="0" id="pageFrame">

  <frame src="${basePath}homepage/headerView" name="header" scrolling="no" noresize="noresize" id="header" title="header" />
  <frameset rows="*" cols="235,*" framespacing="0" frameborder="no" border="0">
    <frame src="${basePath}homepage/menuView" name="menu" scrolling="no" noresize="noresize" id="menu" title="menu" />
    <frame src="${basePath}homepage/workspaceView" name="workspace" id="workspace" title="workspace" />
  </frameset>
  
</frameset>