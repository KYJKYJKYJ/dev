<%@page import="DAO.MemDAO" %>
<%@page import="DTO.MemDTO" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>KH & GYM</title>
<!-- Bootstrap -->

<link href="../css/bootstrap.min.css" rel="stylesheet">
<!-- font awesome -->
<link href="../css/font-awesome.min.css" rel="stylesheet">
<!-- Custom Style -->
<link href="../css/style.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="../js/pwSearch.js"></script>
<script src="../js/bootstrap.min.js"></script>



 
<!-- 부트스트랩 -->
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-theme.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">


<!-- css 적용 -->
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/nav_accordian.css">


 <!-- js 적용 -->
<script type="text/javascript" src="../js/main_navaccordian.js"></script>
 

<script type="text/javascript">
 
 
</script>
<style type="text/css">
.col-md-3{
   margin: 0 auto;
   float: inherit;
}
.page-header{
	text-align : center;
}
.submit
</style>
</head>
<body>

 <div class="container">
      <div class="row">
         <div class="page-header">
            <h2>KHGYM 비밀번호 찾기</h2>
         </div>
         <div class="col-md-3">
            <div class="login-box well">
          			      <legend>비밀번호 찾기</legend>
                  <div class="form-group">
                  
                     <label for="userID-ID">아이디</label> <input name="user_id"  id="user_id"
                        placeholder="ID" type="text"
                        class="form-control" />
                  </div>
                  
                  <div class="form-group">
                     <label for="user_email">이메일</label> <input name="user_email" id="user_email"  
                     placeholder="e-mail" type="text"
                        class="form-control" />
                  </div>
                  
               
                   <span class='text-center'><a href="Login.do" class="text-sm">로그인 화면으로</a></span>
                   <span>/</span>
                   <input type="button" id="pwSearchbtn" style="background-color:inherit;
                    border-style:none; cursor:pointer; color:SteelBlue; font-size: 14px" value="찾기"/>
                                     <form accept-charset="UTF-8" role="form" method="post" action="pwSearchPro.do" id="frm">
                   
       
               </form>
            </div>
         </div>
      </div>
   </div>
  
   
    
</body>
</html>