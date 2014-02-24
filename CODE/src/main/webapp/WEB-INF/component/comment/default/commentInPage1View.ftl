<div class="panel panel-default">
<div class="panel-heading">&nbsp;会员评价</div>
<div class="panel-body right-content">
		
		<ul class="media-list">
		<#list dtos as item>
		  <li class="media comment_popover" data-article-thumbnail="${item.article.homepageImg}" data-article-title="${item.article.name}" data-comment="${item.comment.content}">
		    <a class="pull-left" href="#" style="width:20%;">
		      <img class="media-object" src="${item.consumer.thumbnailPath}" style="width:100%;" />
		    </a>
		    <div class="media-body text-info">
		      <h5 class="media-heading">${item.consumer.name}</h5>
		      	<div>${item.comment.content}</div>
		    </div>
		  </li>
		</#list>
		</ul>
</div>
</div>
<script>
$(function(){
	$(".comment_popover").popover({
		trigger:"hover",
		html:true,
		placement:"left",
		content:function(){
			var homepageImg=$(this).attr("data-article-thumbnail");
			var title=$(this).attr("data-article-title");
			var remark=$(this).attr("data-comment");
			var html="<div style='width:250px;'>"+
			"<div><img style='width:100%;' src='"+homepageImg+"' /></div>"+
			"<div><h3>"+title+"</h3></div>"+
			"<p class='text-info'>"+remark+"</p>"+
			"</div>";
			return html;
		}
	});
});
</script>