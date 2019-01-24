<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_019_dom_tagname</title>
</head>
<body>
	<p>content1</p>
	<p>content2</p>
	<p>content3</p>
	<p>content4</p>
	
	<script type="text/javascript">
		var pNode = document.getElementsByTagName("p");
		console.log(pNode.length);
		pNode[0].style.backgroundColor="yellow";
	</script>
</body>
</html>