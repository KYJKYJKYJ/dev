<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
<%-- <%
	String data = request.getParameter("data");
	out.print(data);
%> --%>

<p>${param.data}</p> <!-- 파라미터값을 가져와서 출력함 (위 코드와 동일, param = 파라미터)-->

<%-- <%
	String chk[] = request.getParameterValues("chk");
	for(String sn: chk)
		out.print(sn+"<br/>");
%> --%>

<p>${paramValues.chk[0]}</p>
<p>${paramValues.chk[1]}</p>
<p>${paramValues.chk[2]}</p>
</body>
</html>