<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
   $(document).ready(function() {
	   if('${requestScope.id}') { // 어떤 값이 있으면 true 없으면 false
	  	alert('아이디 비밀번호를 확인하세요');
        $("fid").val('${requestScope.id}'); // 잘못 입력한 아이디 값을 보여줌
	   }
   });
   /* 특정 부분이 아니라 전체가 바뀌어버리는데, 특정 부분만 바꾸려면 ajax를 이용해야한다. */
</script>
</head>
<body>
<c:choose>
<c:when test="${empty sessionScope.logOk}"> <%-- logOk가 null이면 로그인이 안되어 있음 --%>
<div class="login">
            <form action="login" method="post">
               <table>
                  <tr>
                     <td>아이디</td>
                     <td><input type="text" name="fid" id="fid"></td>
                  </tr>
                  <tr>
                     <td>비밀번호</td>
                     <td><input type="password" name="fpass" id="fpass"></td>
                  </tr>
                  <tr>
                     <td colspan="2" align="center"><input type="submit"
                        value="로그인"> <input type="reset" value="취&nbsp;&nbsp;소"></td>
                  </tr>
               </table>
            </form>
         </div>
</c:when>
<c:otherwise> <%-- 로그인 되어 있는 상태 --%>
<div class="logout">
	<a href="logout">로그아웃</a>
</div>
</c:otherwise>
</c:choose>
<%-- 세션이 유지되는 동안엔 서버를 재시작하면 안됨. 세션 정보가 삭제되어버림 --%>
</body>
</html>