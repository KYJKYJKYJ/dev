<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_018_dom_id</title>
</head>
<body>
<!-- 
1.(X)HTML문서의 구조를 가리켜 문서객체모델(Document Object Model)이라한다.
2.(X)HTML은 각 태그마다 기능과 속성이 있다.
예로 , <img>태그는 문서에 이미지를 출력하는 기능이 있고, 속성으로 src와 alt를
포함하고 있다.
3.문서객체모델(DOM)은 자바스크립트를 사용하여 문서 객체를 선택하고 속성 및
 스타일(CSS)을 적용하기 위해서 사용된다.
4.자바스크립트 문서 객체 모델(DOM)은 IE8 이하버전과 그외 파이어폭스, 크롬, 사파리
  등의 브라우저 간에 호환성이 떨어진다.
5. (X)HTML의 문서 객체 구조는 트리 구조로 되여 있다. ROOT(HTML)요소를 기준으로
   가지처럼 뻗어나가는 것을 노드(NODE)라 한다. 
6. 노드에는 (X)HTML태그를 연결하는 요소노드(ELEMENT NODE), 텍스트를 연결하는
   텍스트노드(TEXT NODE), (X)HTML태그에 속성을 연결해주는 
    속성 노드(ATTRIBUTE NODE)가 있다.
    
[선택자]
선택자에는  직접 문서에서 요소를 선택해오는 직접선택자와  특정 요소를 기준으로
인접해 있는 요소를 선택하는 인접관계선택자가 있다.
1. 직접선택자 : id, 요소명, 폼명(form Name)
2. 인접선택자 : parentNode, childNode, children, firstChild,
              previousSibling, nextSibling  
 -->
 
 <h1 id ="selector">선택자</h1>
 <script type="text/javascript">
	var hNode = document.getElementById("selector");
	//alert(hNode.nodeName); //노드의 이름확인 h1
	hNode.style.color = "green";
	//html을 객체로 변환하여 접근
 </script>
</body>
</html>