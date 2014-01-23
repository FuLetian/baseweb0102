<!-- big image -->
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<img src="../images/big.jpg" class="image-equal-width"/>
		</div>
	</div>
</div>
<!-- //big image -->

<!-- channels -->
<div class="container margin-top-line">
	<div class="row">
		<#list channels as item>
		<div class="col-xs-3"><img src="../images/channel1.png" class="image-equal-width" alt="${item.name}" /></div>
		</#list>
	</div>
</div>
<!-- //channels -->