<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_17_sql</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
<!-- http://localhost:8090/el_jstl/jstl_17_sql.jsp?query=ex -->
<sql:setDataSource var="conn" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin://@127.0.0.1:1521:xe" 
user="hr" password="a1234"/>

<sql:query var="rs" dataSource="${conn}">
select * from employees where first_name like ?
<sql:param value="%${param.query}%"/> <%-- ?의 파라미터 값을 받아서 씀 --%>
</sql:query>

<c:forEach items="${rs.rows}" var="data"> <!-- rs에 데이터 가져올때는 rs.rows 라고 정해놓고 쓴다함 -->
<p>
	<c:out value="${data.first_name}" />
	<c:out value="${data['email']}" />
</p>
<!-- mybatis에서 사용하는 쿼리방법 -->
</c:forEach>
</body>
</html>