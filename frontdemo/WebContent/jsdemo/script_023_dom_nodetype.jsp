<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_023_dom_nodetype</title>
</head>
<body>
<!-- 
인접관계선택자를 이용해서  다른 노드를 접근할때는
IE8버전 이하과 그 밖에 브라우저(파이어폭스, 크롬, 사파리)등의 에서는 공백문자의 인식여부 차이가 있다.

이를 해결하기 위해서 nodeType, nodeName, nodeValue을 이용한다.
 
   [노드의 종류]      nodeType     nodeName    nodeValue
 element(요소)노드         1            요소명               null
 attribute(속성)노드     2            속성명               속성값
 text(텍스트)노드            3            #text       문자열
-->

	<div id="wrap">
		<p>content1</p>
		<p>content2</p>
		<span><a href="#">이동</a></span>
	</div>
	
	<script type="text/javascript">
		var pNode = document.getElementsByTagName("p")[1];
		// 1 P null
		document.write(pNode.nodeType + " " +
					   pNode.nodeName + " " +
					   pNode.nodeValue + "<br/>");
		
		var pFirstChild = pNode.firstChild;
		// 3 #text content2
		document.write(pFirstChild.nodeType + " " + 
					   pFirstChild.nodeName + " " +
					   pFirstChild.nodeValue + "<br/>");
		
		var divAttr = document.getElementById("wrap").attributes[0];
		console.log(divAttr.nodeName);
		// 2 id wrap
		document.write(divAttr.nodeType + " " + 
				   	   divAttr.nodeName + " " +
				       divAttr.nodeValue + "<br/>");
	</script>
</body>
</html>