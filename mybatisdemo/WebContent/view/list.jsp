<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
 
		$("#all").click(function selectAll() {
	  		var checkTest = $(this).prop('checked');
	  		if(checkTest)
		  		$('input[name="chk"]').prop('checked', true);
	  		else
		  		$('input[name="chk"]').prop('checked', false);
	  		
	  		/* $('[type=checkbox]').prop('checked', true) */
  		});
		
		$("#del").click(function delsubmit() {
			document.frm.submit();
		});
});
</script>
</head>
<body>
 <div class="wrap">
  <input type="button" id="del" value="삭제"/>
  <form name="frm" method="get" action="myList">
   <table>
    <tr>
    <th>
     <label for="all"><input type="checkbox" id="all" value="전체"/>전체</label>
    </th>
     <th>num</th><th>name</th><th>age</th><th>loc</th>
    </tr>
    
    <c:forEach items="${requestScope.aList}" var="dto">
      <tr>
       <td><input type="checkbox" name="chk" value="${dto.num}" /></td>
       <td>${dto.num}</td>
       <td>${dto.name}</td>
       <td>${dto.age}</td>
       <td>${dto.loc}</td>
      </tr>
    </c:forEach>
   </table>
   </form>
 </div>
</body>
</html>







