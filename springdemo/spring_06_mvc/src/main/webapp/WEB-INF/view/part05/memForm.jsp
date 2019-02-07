<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" action="memInsert.htm" method="post">
    	<label for="fname">이름</label>
    	<input type="text" name="name" id="fname" value=""/><br/>
    	<label for="fage">나이</label>
    	<input type="text" name="age" id="fage"/><br />
    	<label for="floc">거주지</label>
    	<input type="text" name="loc" id="floc"/>
    	<input type="submit" value="commit" />
  </form>
</body>
</html>