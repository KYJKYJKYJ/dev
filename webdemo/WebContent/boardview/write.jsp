<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	//enter가 줄바뀜이 되도록 /n을 br로 바꿔준다
	$('form').on('submit', function(){
		//name이라는 속성에서 컨텐츠값을 가지고와서 html에 br로 바꾸어서 넣어주어야 한다.
		//속성으로 접근, 정규화표현식 사용(/\n/gi : 모든 enter값)
	    $('[name=content]').val($('[name=content]').val().replace(/\n/gi, '<br/>'));
	 });
});
</script>
</head>

<body>
   
   <form name="frm" method="post" enctype="multipart/form-data" action="write.do">
      <!-- 답변일 때 -->
      <c:if test="${!empty param.num}">
      	<input type="hidden" name="num" value="${param.num}" />
      	<input type="hidden" name="ref" value="${param.ref}" />
      	<input type="hidden" name="re_step" value="${param.re_step}" />
      	<input type="hidden" name="re_level" value="${param.re_level}" />
      	<input type="hidden" name="pageNum" value="${param.pageNum}" />
      	<%-- 이 값들을 받아서 답변글로 등록되는 것, 확인하고 싶으면 hidden을 text로 --%>
      </c:if>
      
      <!-- 평상시 일 때-->      
      <table>
         <tr>
            <td align="right" colspan="2"><a href="list.do">리스트</a></td>
         </tr>

         <tr>
            <td width="20%" align="center">글쓴이</td>
            <td width="80%"><input type="text" name="writer" /></td>
         </tr>

         <tr>
            <td width="20%" align="center">Email</td>
            <td width="80%"><input type="text" name="email" /></td>
         </tr>

         <tr>
            <td width="20%" align="center">제목</td>
            <td width="80%">
            	<c:if test="${!empty param.num}">
            	<span>[답변]</span>
            	</c:if>
            	<!-- 게시글 제목에 [답변]이 붙음 -->                       
               <input type="text" name="subject"  />                
            </td>
         </tr>

         <tr>
            <td width="20%" align="center">내용</td>
            <td width="80%"><textarea name="content" rows="13" cols="40"></textarea></td>
         </tr>

         <tr>
            <td width="20%" align="center">파일첨부</td>
            <td width="80%" id="fileDiv"><input type="file" name="upload" /></td>
         </tr>

         <tr>
            <td colspan="2" align="center">
            <input type="submit" value="글쓰기" />&nbsp;&nbsp;&nbsp;
            <input type="reset" value="취소" /></td>
         </tr>
      </table>
   </form>
</body>
</html>