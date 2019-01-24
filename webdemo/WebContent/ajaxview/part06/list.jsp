<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<table border="1" width="70%">
  <tr>
    <th>번호</th><th>제목</th>
  </tr>
  
   <c:forEach var="dto" items="${requestScope.list}">
     <tr>
      <td>${dto.num}</td>
    <td><a href="disView?num=${dto.num}">
                       ${dto.title}</a></td>
     </tr>
   </c:forEach>  
 </table>
</body>
</html>