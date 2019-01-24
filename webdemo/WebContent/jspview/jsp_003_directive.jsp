<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_002_directive</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
      $(document).ready(function(){
         
      });
   </script>
</head>
<body>
<%-- 

* jsp에서 제공하는 기본 구성요소 
2 directive(지시어):jsp파일내에서 jsp를 실행할 컨테이너에서 해당페이지를 처리하는데 필요한 정보를 제공해준다.
<%@ %>
(1) page:jsp페이지에 대한 속성을 지정하는 지시어이다.
(2)include: 여러 jsp페이지에서 공통으로 사용되는 값을 지정할 때 사용하는 지시어이다.
(3)taglib(태그라이브러리): 사용자 정의 태그를 등록할때 사용되는 지시어이다.
(JSTL:표준)자바기반 웹프로그램을 작성한다고 하면 이걸 꼭 사용하기 때문에 반드시 꼭 해놓아야함

--%>
<%
Calendar cal=Calendar.getInstance();
%>


<p><%=cal %></p>
</body>
</html>