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
$(document).ready(function(){
	$('#submit').on('click', function() {
		var cnt = $("#code option:selected").attr('id');	
		if($('input[name=sacnt]').val() > cnt || cnt == 0) {
			alert("재고가 부족합니다.")
			return false;
		}	
	});
});
</script>
</head>
<body>
 <form name="frm" action="salesPro.do" method="POST">
  <table>
  <caption>판매입력</caption>
    <tr>
     <th>상품코드</th>
     <td>
     <select name="code" id="code">
        <c:forEach items="${aList}" var="dto">
        	<option value="${dto.code}" id="${dto.cnt}"> ${dto.code}
        </c:forEach>
      </select></td>
     </tr>
     
      <tr>
      <th>판매수량</th>
      <td><input type="text" name="sacnt" id="saleCnt" /></td>
     </tr>
     
     <tr>
      <td colspan="2">
       <input type="submit" value="commit" id="submit" />
     </td>
    </tr>
  </table>
 </form>
</body>
</html>












