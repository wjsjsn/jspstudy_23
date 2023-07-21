<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 600px;
	margin-top: 50px;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid tomato;
	text-align: center;
}
</style>
<%-- jQuery 라이브러리 CDN --%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btn").on("click", function() {
			//클릭을 하면 계속 추가되는 현상을 방지 => 초기화
			$("#out").empty();
			$.ajax({
				url : "data04.json",
				method : "get",
				dataType : "json",
				success : function(data) {
					var table = "<table>";
					table += "<thead><tr><th>이름</th><th>범위</th></tr></thead>"
					table += "<tbody>";
					
					$.each(data, function () {				
					table += "<tr><td>" + this["name"] + "</td><td>" + this["scope"] + "</td></tr>";
				});
			table += "</tbody></table>";
			$("#out").append(table);
				},
				error : function() {
					alert("가져오기 실패");
				}
			});			
		});
	});
</script>
</head>
<body>
	<div id="btn">json 파일 가져오기</div>
	<div id="out"></div>
</body>
</html>
