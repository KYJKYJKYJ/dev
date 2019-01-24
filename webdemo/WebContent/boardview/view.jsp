<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 table{
  border:1px solid black;
  width:80%;
 }
 
 table, th, td {
  border:1px solid black;
  border-collapse: collapse;
 }
</style>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

 <script type="text/javascript">
   $(document).ready(function(){
      $('.list').on('click', function() {
    	  $('form').attr('action', 'list.do');
    	  $('form').submit();
      });
      
      $('.reply').on('click', function() {
    	 $('form').attr('action', 'writeForm.do');
    	 $('form').submit();
      });
      
      $('.update').on('click', function() {
    	  $('form').attr('action', 'updateForm.do');
    	  $('form').submit();
      });
      
      $('.del').on('click', function() {
    	  $('form').attr('action', 'delete.do');
    	  $('form').submit();
      });
   });
 </script>
 
</head>
<body>
 <table>
      <tr>
         <td width="20%">글쓴이</td>
         <td>${dto.writer}</td>
         <td width="20%">조회수</td>
         <td>${dto.readcount}</td>
      </tr>

      <tr>
         <td>제목</td>
         <td colspan="3">${dto.subject}</td>
      </tr>

      <tr>
         <td>메일</td>
         <td colspan="3">${dto.email}</td>
      </tr>

      <tr>
         <td>내용</td>
         
         <td colspan="3">
         ${dto.content }
         </td>
      </tr>

      <tr>
         <td>파일</td>
         <td colspan="3"><a href="download.do?num=${dto.num}">${dto.upload}</a>
         </td>
      </tr>
   </table>
   
   <!-- 입력된 내용을 처리하는 서버 프로그램의 URI를 지정하는 역할 -->
   <form name="frm" method="post">
    <input type="hidden" name="num" value="${dto.num}" />
    <input type="hidden" name="ref" value="${dto.ref}"  />
    <!-- ref : 제목 + 답변글 그룹 --> 
    <input type="hidden" name="re_step" value="${dto.re_step}" />
    <!-- re_step : 출력순서, 제목: 최근 입력 먼저 출력, 답변: 최근 입력 먼저 출력 -->
    <input type="hidden" name="re_level" value="${dto.re_level}" />
    <!-- re_level : 들여쓰는 것, 답변 되는거 들여쓰는 순서 말함 -->
    <!-- 제목 :~~~~~
    		답변1: ~~~~~
    			답변2: ~~~~ 처럼 -->
    <input type="hidden" name="pageNum" value="${param.pageNum}" />
    
   <input type="button" value="목록" class="list" /> 
   <input type="button" value="답변" class="reply" /> 
   <input type="button" value="수정" class="update" />
   <input type="button" value="삭제" class="del" />
   </form>
</body>
</html>
