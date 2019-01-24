<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
	<%
		String result = (String) request.getAttribute("result");
		String com_result = (String) request.getAttribute("com_result");
				
		out.print("사용자 : " + result + ", " + "컴퓨터 : " + com_result + "\n");
		
		if(result.equals(com_result))
			out.println("무승부 입니다.");
		
		if(result.equals("가위") && com_result.equals("보"))
			out.println("이기셨습니다.");
		
		if(result.equals("가위") && com_result.equals("바위"))
			out.println("지셨습니다.");
		
		if(result.equals("바위") && com_result.equals("가위"))
			out.println("이기셨습니다.");
		
		if(result.equals("바위") && com_result.equals("보"))
			out.println("지셨습니다.");
		
		if(result.equals("보") && com_result.equals("바위"))
			out.println("이기셨습니다.");
		
		if(result.equals("보") && com_result.equals("가위"))
			out.println("지셨습니다.");
	%>
</body>
</html>