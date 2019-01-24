<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!-- fmt = format -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_14_formatNumber.jsp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
	<%-- 숫자형식을 지정해주는 formatNumber요소 --%>
	<c:set var = "num1" value="10000" />
	<c:set var = "num2" value="0.2" />
	
	<%-- type속성은  number, percent, currency를 사용할 수 있다. --%>
	<!-- 10,000 -->
	<p>
	<fmt:formatNumber value="${num1}" type="number" />
	</p>
	
	<%-- java.text.DecimalFormat을 참조해서 pattern 설정 --%>
	<!-- 10,000.00 -->
	<p>
	<fmt:formatNumber value="${num1}" type="number" pattern="0,000.00" />
	</p>
	
	<!-- 20% -->
	<p>
	<fmt:formatNumber value="${num2}" type="percent" />
	</p>
	
	<!-- ￦10,000 -->
	<p>
	<fmt:formatNumber value="${num1}" type="currency" />
	</p>
	
	<!-- $10,000 -->
	<p>
	<fmt:formatNumber value="${num1}" currencySymbol="$" type="currency" />
	</p>
</body>
</html>