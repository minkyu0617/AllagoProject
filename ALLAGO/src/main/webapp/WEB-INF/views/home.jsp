<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>ALLAGO - Analysis from Article</title>

<!-- Bootstrap Core CSS -->
<link
	href="/allago/resources/styles/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/allago/resources/styles/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="/allago/resources/styles/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="/allago/resources/styles/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/series-label.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script>
	
$(function() {
	
	var isRunning = false;
	
	Highcharts.chart('container', {
	    title: {text: 'Solar Employment Growth by Sector, 2010-2016'},
	    subtitle: {text: 'Source: thesolarfoundation.com'},
	    yAxis: {title: {text: 'Number of Employees'}},
	    legend: {
	        layout: 'vertical',
	        align: 'right',
	        verticalAlign: 'middle'
	    },
	    plotOptions: {
	        series: {
	            label: {connectorAllowed: false},
	            pointStart: 2010
	        }
	    },
	
	    series: [{
	        name: 'Installation',
	        data: [43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175]
	    }, {
	        name: 'Manufacturing',
	        data: [24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434]
	    }, {
	        name: 'Sales & Distribution',
	        data: [11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387]
	    }, {
	        name: 'Project Development',
	        data: [null, null, 7988, 12169, 15112, 22452, 34400, 34227]
	    }, {
	        name: 'Other',
	        data: [12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111]
	    }],
	
	    responsive: {
	        rules: [{
	            condition: {maxWidth: 500},
	            chartOptions: {
	                legend: {
	                    layout: 'horizontal',
	                    align: 'center',
	                    verticalAlign: 'bottom'
	                }
	            }
	        }]
	    }
	});
		
	$('a[id^=compCode]').on('click', function(event) {
		
		if (isRunning) {
			alert('이전 작업 진행 중');
			return;
		}
		
		var compCode = $(this).attr('data-id');
		
		$.ajax({
			url : "/allago/stock/trend.action",
			data : {
				"compCode" : compCode
			},
			method : "GET",
			success : processResult,
			error : function(xhr, status, err) {
				alert('검색 실패 ' + err);
				isRunning = false;
			}
		});
		isRunning = true;
	});
	
	function processResult(data, status, xhr) {

	        Highcharts.chart('container2', {
	            chart: {zoomType: 'x'},
	            title: {text: 'USD to EUR exchange rate over time'},
	            subtitle: {
	                text: document.ontouchstart === undefined ?
	                        'Click and drag in the plot area to zoom in' : 'Pinch the chart to zoom in'
	            },
	            xAxis: {type: 'marketDate'},
	            yAxis: {title: {text: 'Exchange rate'}},
	            legend: {enabled: false},
	            plotOptions: {
	                area: {
	                    fillColor: {
	                        linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
	                        stops: [
	                            [0, Highcharts.getOptions().colors[0]],
	                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
	                        ]
	                    },
	                    marker: {radius: 2},
	                    lineWidth: 1,
	                    states: {hover: {lineWidth: 1}},
	                    threshold: null
	                }
	            },

	            series: [{
	                type: 'area',
	                name: 'Closing Price',
	                data: data
	            }]
	        });
	    }
	
});

</script>
</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">ALLAGO v1.0</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> User
								Profile</a></li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
								Logout</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
								Charts</a></li>
						<li><a href="forms.html"><i class="fa fa-edit fa-fw"></i>
								Forms</a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h2 class="page-header">뉴스 기사를 통한 분석</h2>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-bar-chart-o fa-fw"></i> 단어 빈도수
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div id="container"
								style="min-width: 310px; height: 400px; margin: 0 auto"></div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-bar-chart-o fa-fw"></i> 관련 주식종목
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-4">
									<div class="table-responsive">
										<table class="table table-bordered table-hover table-striped">
											<thead>
												<tr>
													<th>순위</th>
													<th>주식 종목</th>
													<th>상관계수</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td><a id="compCode005930" data-id="005930">삼성전자</a></td>
													<td>0.8121</td>
												</tr>
												<tr>
													<td>2</td>
													<td>SK하이닉스</td>
													<td>0.6121</td>
												</tr>
												<tr>
													<td>3</td>
													<td>셀트리온</td>
													<td>0.4121</td>
												</tr>
												<tr>
													<td>4</td>
													<td>POSCO</td>
													<td>0.3121</td>
												</tr>
												<tr>
													<td>5</td>
													<td>삼성물산</td>
													<td>0.2121</td>
												</tr>
											</tbody>
										</table>
									</div>
									<!-- /.table-responsive -->
								</div>
								<!-- /.col-lg-4 (nested) -->
								<div class="col-lg-8">
									<div id="container2"
										style="min-width: 310px; height: 400px; margin: 0 auto"></div>
								</div>
								<!-- /.col-lg-8 (nested) -->
							</div>
							<!-- /.row -->
						</div>
						<!-- /.panel-body -->
					</div>
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->


	<!-- Bootstrap Core JavaScript -->
	<script
		src="/allago/resources/styles/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="/allago/resources/styles/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="/allago/resources/styles/dist/js/sb-admin-2.js"></script>

</body>

</html>
