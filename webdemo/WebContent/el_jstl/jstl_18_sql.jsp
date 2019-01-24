<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_18_sql</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
<sql:setDataSource var="conn"
driver="oracle.jdbc.OracleDriver"
url="jdbc:oracle:thin://@127.0.0.1:1521:xe" 
user="hr"
password="a1234"/>

<%-- insert 구문 --%>
<%-- <sql:update dataSource="${conn}">
insert into mem values(mem_num_seq.nextval,?,?,?)
<sql:param value="test01"></sql:param>
<sql:param value="30"></sql:param>
<sql:param value="seoul"></sql:param>
</sql:update> --%>

<%-- update 구문 --%>
<sql:update dataSource="${conn}">
	update mem set name=? where num=?
	<sql:param value="test2"></sql:param>
	<sql:param value="1"></sql:param>
</sql:update>

<%-- delete 구문 --%>
<sql:update dataSource="${conn}">
delete from mem where num=?
<sql:param value="1"></sql:param>
</sql:update>

<sql:query var="rs" dataSource="${conn}">
select * from MEM order by NUM
</sql:query>
<%-- 쿼리문에 세미콜론 찍지 않는 것에 유의 --%>

<c:forEach items="${rs.rows}" var="data">
<p>
	<c:out value="${data['num']}"></c:out>
	_
	<c:out value="${data['name']}"></c:out>
	_
	<c:out value="${data['age']}"></c:out>
	_
	<c:out value="${data['loc']}"></c:out>
</p>
</c:forEach>
</body>
</html>