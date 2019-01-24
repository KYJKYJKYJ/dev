<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_004_process</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
      $(document).ready(function(){
         
      });
   </script>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String fname=request.getParameter("fname");


/* java소스(=sevlet소스) */
%>

<p><%=fname%></p>
 
</body>
</html>