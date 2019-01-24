<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_16_function</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
 <!-- jstl에서 제공되는 문자열 함수 -->
 <c:set var="str1" value="Functions" />
 <c:set var="str2" value="java test" />
 
 <!-- length:9 -->
 <p>length:${fn:length(str1)}</p>
 <!-- fn:함수명(인자값) 형식으로 써야함! string에서 제공하는 메소드들과 이름이 동일하다 -->
 
 <!-- toUpperCase:FUNCTIONS -->
 <p>toUpperCase:${fn:toUpperCase(str1)}</p>
 <!-- replace:jsp test -->
 <p>replace:${fn:replace(str2, "java", "jsp")}</p>
 <!-- substring:es -->
 <p>substring:${fn:substring(str2, 6, 8)}</p>
 <!-- indexOf:5 -->
 <p>indexOf:${fn:indexOf(str2, "test")}</p>
 <!-- contains:false -->
 <p>contains:${fn:contains(str1, str2)}</p>
 
 <c:set var="str3" value="red, green, blue" />
 <c:set var="arr" value='${fn:split(str3,",")}' />
 <!-- 배열로 리턴이 됨 -->
 <p>split : ${arr[0]} </p>
 <p>split : ${arr[1]}</p>
 <p>split : ${arr[2]}</p>
 <hr/>
 <c:forEach items="${arr}" var="data">
 	<p><c:out value="${data}" /></p>
 </c:forEach>
</body>
</html>