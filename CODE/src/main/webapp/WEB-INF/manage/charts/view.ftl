<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${basePath}h/javascript/bootstrap-google/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${basePath}h/javascript/jquery-1.9.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${basePath}h/javascript/bootstrap-google/js/bootstrap.min.js"></script>

<!--knockout-->
<script src="${basePath}h/javascript/knockout-3.0.0.js"></script>

<!--jquery.form-->
<script src="${basePath}h/javascript/jquery.form.js"></script>

<script src="${basePath}h/javascript/Highcharts-3.0.10/js/highcharts.js"></script>
<script src="${basePath}h/javascript/Highcharts-3.0.10/js/modules/exporting.js"></script>

<script type="text/javascript">
    
$(function(){
	onTab1Click();
});
function onTab1Click(){
	
	if($("#container").html()){
		return false;
	}
	
	$.getJSON("${basePath}charts/chart1-data",function(data){
		
        $('#container').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: 'Historic World Population by Region'
            },
            subtitle: {
                text: 'Source: Wikipedia.org'
            },
            xAxis: {
                categories:data.days,
                title: {
                    text: null
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Population (millions)',
                    align: 'high'
                },
                labels: {
                    overflow: 'justify'
                }
            },
            tooltip: {
                valueSuffix: ' millions'
            },
            plotOptions: {
                bar: {
                    dataLabels: {
                        enabled: true
                    }
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -40,
                y: 100,
                floating: true,
                borderWidth: 1,
                backgroundColor: '#FFFFFF',
                shadow: true
            },
            credits: {
                enabled: false
            },
            series: [{
                name: '总订单数量',
                data: data.totalOrderCount
            },{
            	name:'成功交易数量',
            	data:data.successOrderCount
            },{
            	name:'收藏数量',
            	data:data.collectionOrderCount
            }]
        });

	});
}
    
</script>
		
<div>

<div class="tabbable tabs-left">

  <ul class="nav nav-tabs">
    <li class="active" onclick="onTab1Click()"><a href="#tab1" data-toggle="tab">Section 1</a></li>
    <li><a href="#tab2" data-toggle="tab">Section 2</a></li>
  </ul>
  
  <div class="tab-content">
    <div class="tab-pane active" id="tab1">
      <div id="container" style="width:100%; height: 400px; margin: 0 auto"></div>
    </div>
    <div class="tab-pane" id="tab2">
      <p>Howdy, I'm in Section 2.</p>
    </div>
  </div>
  
</div>

</div>