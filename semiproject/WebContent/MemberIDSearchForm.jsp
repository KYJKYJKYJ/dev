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
<title>로그인 화면</title>
<!-- Bootstrap -->

<link href="../css/bootstrap.min.css" rel="stylesheet">
<!-- font awesome -->
<link href="../css/font-awesome.min.css" rel="stylesheet">
<!-- Custom Style -->
<link href="../css/style.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="/..js/bootstrap.min.js"></script>
<script type="text/javascript" src="../jquery.js"></script>
<script type="text/javascript" src="../js/IDsearch.js"></script>


 
<!-- 부트스트랩 -->
<script src="js/bootstrap.min.js"></script>
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
 $('#btn').on('click', function(){
   
 });
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
            <h2>KHGYM 아이디 찾기</h2>
         </div>
         <div class="col-md-3">
            <div class="login-box well">
               <form accept-charset="UTF-8" role="form" id="frm">
                         <legend>아이디 찾기</legend>
                  <div class="form-group">
                  
                     <label for="username-name">이름</label> <input name="user_name"  id="user_name"
                        placeholder="name" type="text"
                        class="form-control" />
                  </div>
                  
                  <div class="form-group">
                     <label for="user-email">이메일</label> <input name="user_email" id="user_email"  
                     placeholder="e-mail" type="email"
                        class="form-control" />
                  </div>
                  
               
                       <span class='text-center'><a href="Login.do"
                     class="text-sm">로그인 화면으로</a></span>
                                  <span>/</span>
                   <button id="searchbtn" style="background-color:inherit; border-style:none; cursor:pointer; color:SteelBlue; font-size: 14px" >
                      찾기</button>
                     
              </form>
            </div>
                     
         </div>
      </div>
   </div>
            <div id="abcd"></div>
            
            <p></p>
    
</body>
</html>