<!-- location -->
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="location color-greys">大众评价:</div>
		</div>
	</div>
	
</div>
<!-- //location -->

<!-- comment -->
<div class="container" data-bind="foreach:comments">
	<div class="row  margin-top-line">
		<div class="col-xs-1"><img data-bind="attr{'src':consumer.thumbnailPath}" class="image-equal-width"/></div>
		<div class="col-xs-11">
			<div class="detail-comment">
				<div class="detail-comment-title">
					<span class="glyphicon glyphicon-star"></span>
					<span class="glyphicon glyphicon-star"></span>
					<span class="glyphicon glyphicon-star"></span>
					
					<span class="detail-comment-title-date">2010-10-10 10:10</span>
				</div>
				<div class="detail-comment-text">
					<div class="detail-comment-text-title"><b>评&nbsp;&nbsp;&nbsp;价:</b></div>
					<div class="detail-comment-text-content" data-bind="text:comment.content">各位各位广东人鬼地方个个人个人个人个人提供好人说都噶尔各色人各色人各色人</div>
				</div>
				<div class="detail-comment-text-reply">
					<div class="detail-comment-text-title"><b>评&nbsp;&nbsp;&nbsp;价:</b></div>
					<div class="detail-comment-text-content" data-bind="text:comment.replyContent">各位各位广东人鬼地方个个人个人个人个人提供好人说都噶尔各色人各色人各色人</div>
				</div>
				
			</div>
		</div>
	</div>
</div>
<!-- //comment -->