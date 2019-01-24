<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%-- <%@:directive 현재페이지보여줌 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_002_script</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<%-- 

*JSP에서 제공하는 기본 구성요소
1 스크립트요소:jsp에서 실시간으로 문서의 내용을 생성하기 위해 사용된다.
(1)표현식(expression):값을 출력한다.<%= %>
(2)스크립트릿(scriptlet):자바코드를 구현한다.<% %>
(3)선언부(declaration):멤버변수,메소드를 정의한다.<%! %> 

--%>

	<%!int x;//멤버변수
	int y;

	public void setData(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getSum() {
		return x + y;
	}
	%>
	
	<%
	int z=20;//지역변수
	setData(10,5);
	%>
	
	<p><%=getSum() %></p>
	<p><%=x%>/<%=this.y%></p> <!-- <%-- <%=this.z%> --%> z지역변수이기 때문에 오류발생 -->
</body>
</html>