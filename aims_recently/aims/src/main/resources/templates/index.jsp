<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Google Pie Chart using Spring</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
   // 시각화 API 및 원형 차트 패키지를 로드합니다.
   google.load('visualization', '1.0', {
        'packages' : [ 'corechart' ]
    });
   // Google Visualization API가 로드될 때 실행할 콜백을 설정합니다.
   google.setOnLoadCallback(drawChart);
   // 데이터 테이블을 생성하고 채우는 콜백,
   // 파이 chcart를 인스턴스화하고 데이터를 전달하고 그립니다..
   function drawChart() {
	 // 데이터 테이블을 생성합니다.
	var data = google.visualization.arrayToDataTable([
              ['Country', 'Area(square km)'],
            <c:forEach items="${pieDataList}" var="entry">
              [ '${entry.key}', ${entry.value} ],
            </c:forEach>
                   ]);
	// 차트 옵션
    var options = {
	  'title' : 'Area-wise Top Seven Countries in ther World',
	  curvType : 'function',
	  legend: {position: 'top'},
	  'width' : 900,
	  'height' : 500
	};
	// 몇 가지 옵션을 전달하여 차트를 인스턴스화하고 그립니다.
    var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
    chart.draw(data, options);
   }
</script>
</head>
<body>
  <div style ="width: 600px;">
    <div id="chart_div"></div>
  </div>
</body>
</html>