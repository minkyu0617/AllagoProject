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
	
	$('button[id=keySearch]').on('click', function(event) {
		
		event.stopPropagation();
		event.preventDefault();
		
		var keyword = $('#search').val();
		
		$.ajax({
			url : "/allago/key/count.action",
			data : {
				"keyword" : keyword
			},
			method : "GET",
			success : processResult2,
			error : function(xhr, status, err) {
				alert('검색 실패 ' + err);
			}
		});
	
		function processResult2(data, status, xhr) {
	
			var keyCount = [];
			
			for (var i = 0; i < data.length; i++) {
				keyCount.push(data[i].keyCount);
			}
			
			Highcharts.chart('container', {
				title : {
					text : keyword+' 키워드 연도별 통계 그래프'
				},
				subtitle : {
					text : '2013년 1월 1일 - 2017년 12월 31일'
				},
				yAxis : {
					title : {
						text : '빈도수'
					}
				},
				plotOptions : {
					series : {
						label : {
							connectorAllowed : false
						},
						pointStart : 0
					}
				},
		
				series : [ {
					name : '빈도수',
					data : keyCount
				} ],
		
				responsive : {
					rules : [{
						condition : {
							maxWidth : 500
						},
						chartOptions : {
							legend : {
								layout : 'horizontal',
								align : 'center',
								verticalAlign : 'bottom'
							}
						}
					}]
				}
			});
		}
	});
});
</script>
<script>	
$(function() {
	
	$('button[id=keySearch]').on('click', function(event) {
		
		var keyword = $('#search').val();
		
		event.stopPropagation();
		event.preventDefault();
		
		$.ajax({
			url : "/allago/key/stockMasterList.action",
			data : {
				"keyword" : keyword
			},
			method : "GET",
			success : processResult3,
			error : function(xhr, status, err) {
				alert('검색 실패 ' + err);
			}
		});
	});
	
	function processResult3(data, status, xhr) {
		
		$('#relation > tr').remove();
		for(var i = 0; i < 5; i++){
			$('#relation').append('<td><a id="compCode'+data[i].compCode+'" data-id="'+data[i].compCode+'">'+data[i].compName+'</a></td>');
		}
	}
});	
</script>
<script>
$(function() {
	
	$('body').on('click', 'a[id^=compCode]',function(event) {

		var compCode = $(this).attr('data-id');
		var compName = $(this).parent().text();
		
		$.ajax({
			url : "/allago/stock/trend.action",
			data : {
				"compCode" : compCode
			},
			method : "GET",
			success : processResult,
			error : function(xhr, status, err) {
				alert('검색 실패 ' + err);
			}
		});

		function processResult(data, status, xhr) {
	
			var closePrice = [];
			var marketDate = [];
	
			for (var i = 0; i < data.length; i++) {
				closePrice.push(data[i].closePrice);
				marketDate.push(data[i].marketDate);
			}
	
			Highcharts.chart('container2', {
				chart : {zoomType : 'x'},
				title : {text : compName+' 주식 동향'},
				subtitle : {text : '2013년 1월 2일-2017년 12월 31일'},
				xAxis : {
					title : {
						text : 'Market Date'
					},
					data : marketDate
				},
				yAxis : {title : {text : 'Close Price'}},
				legend : {
					enabled : false
				},
				plotOptions: {
	                area: {
	                    fillColor: {
	                        linearGradient: {
	                            x1: 0,
	                            y1: 0,
	                            x2: 0,
	                            y2: 1
	                        },
	                        stops: [
	                            [0, Highcharts.getOptions().colors[0]],
	                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
	                        ]
	                    },
	                    marker: {
	                        radius: 2
	                    },
	                    lineWidth: 1,
	                    states: {
	                        hover: {
	                            lineWidth: 1
	                        }
	                    },
	                    threshold: null
	                }
	            },
				
	            series : [ {
					type : 'area',
					name : 'CLOSE PRICE',
					data : closePrice
				} ]
			});
		}
	});
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
				<a class="navbar-brand" href="/allago/home.action"><img
					src="/allago/resources/images/Allago.png" height=30px width=200px;></a>
			</div>
			<!-- /.navbar-header -->
		</nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-8">
					<div class="input-group custom-search-form">
						<form>
							<p style="font-size:15pt" class="page-header">
								뉴스 기사를 통한 단어 분석 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									type="text" style="width: 400px" placeholder="Search.."
									name="search" id="search">
								<button id="keySearch">
									<i class="fa fa-search"></i>
								</button>
								<table class="table table-bordered table-hover table-striped">
									<tr id="relation"></tr>
								</table>
							</p>
						</form>
						<!-- <input type="text" class="form-control" placeholder="Search...">
						<div class="input-group-btn">
							<button class="btn btn-default" type="button">
								<i class="fa fa-search"></i>
							</button>
						</div> -->
					</div>
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
								<div class="col-lg-12">
									<div id="container2"
										style="min-width: 310px; height: 400px; margin: 0 auto"></div>
								</div>
								<!-- /.col-lg-12 (nested) -->
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
	
	<!-- Custom Theme JavaScript -->
	<script src="/allago/resources/styles/js/home.js"></script>

</body>

</html>
