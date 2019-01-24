<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   <c:if test="${sessionScope.user_id == null}">
       <script>
           alert("로그인 하셔야 이용 하실 수 있습니다.");
           location.href="/semiproject/home/Login.do"; 
       </script>
   </c:if>
</body>
</html>