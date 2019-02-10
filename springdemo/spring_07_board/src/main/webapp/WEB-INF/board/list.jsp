<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.pagelist {
		text-decoration: none;
		color:black;
	}
	
	.pagelist:hover {
		text-decoration: underline;
		color:red;
	}
	
	#table {
		margin-top: 10px;
		border-collapse: collapse;
		border-spacing: 1px;
		border: 1px solid black;
		width: 60%;
		margin : 0 auto;
	}
	
	#time {
		width: 20%;
	}
	
	td, th {
		border: 1px solid black;
	}
</style>

</head>
<body>

<form id="frm" name="frm" method="get" action="write.sb">
		<input type="submit" id="btnWrite" value="글쓰기" />
</form>
	
	<div id="bodywrap">
		<!-- 리스트 출력 -->
		<table id="table">
			<tr>
				<th width="5%">번호</th>
				<th width="35%">제목</th>
				<th width="20%">글쓴이</th>
				<th width="5%">조회수</th>
				<th width="10%" id="time">시간</th>
			</tr>

			<c:forEach var="dto" items="${aList}">
				<tr>
					<td>${dto.num}</td>
					<td>
					<c:url var="path" value="view.sb">
					<c:param name="currentPage" value="${pv.currentPage}" />
					<c:param name="num" value="${dto.num}" />
					</c:url>
					<c:if test="${dto.re_level!=0}">
					 <img src="images/level.gif" width="${20*dto.re_level}"
						  height="15" />
					 <img src="images/re.gif" />
					</c:if>
					<a href="${path}">${dto.subject}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.readcount}</td>
					<td>${dto.reg_date}</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 이전 처리 -->
		<!-- 이전으로 이동할 것이 있을 경우에만 이전이 뜨도록 -->
		<!-- 이전 4 5 6 / 이전을 누르면 1 2 3이 보이도록, 누르면 가장 첫번째 것이 선택이 되도록 -->
		<!-- 이전의 조건 : 현재페이지의 값이 1보다 클때 , 현재페이지-한블럭에보여줄페이지 (4-3=1페이지가 선택되어서 나옴) -->
		<!-- 스프링에서는 파라미터 이름을 정해주어서 사용하니까 유의 -->
		<c:if test="${pv.startPage > 1}">
			<span><a class = "pagelist" href="list.sb?currentPage=${pv.startPage-pv.blockPage}">이전</a></span>
		</c:if>
		
		<!-- 페이지 이동하는 부분 -->
		<c:forEach begin="${pv.startPage}" end = "${pv.endPage}" var = "i" >
			<span><a class = "pagelist" href="list.sb?currentPage=${i}">${i}</a></span>
		</c:forEach>
		
		<!-- 다음 처리 -->
		<!-- 다음으로 이동할 것이 있을 경우에만 다음이 뜨도록 -->
		<!-- 1 2 3 다음 / 다음을 누르면 4 5 6이 보이도록, 누르면 가장 첫번째 것이 선택이 되도록 -->
		<!-- 다음의 조건 : 현재 마지막 페이지보다 토탈페이지가 더 클때, 현재페이지+한블럭에보여줄페이지 (1+3=4페이지가 선택되어서 나옴) -->
		<!-- 리퀘스트 영역에 있는 값들은 '이름.값'으로 가지고 와도 됨(생략해서 많이 사용, 생략하지 않고 다 쓰는것이 정석이기는 함)  -->
		<!-- 스프링에서는 파라미터 이름을 정해주어서 사용하니까 유의 -->
		<c:if test="${pv.endPage < pv.totalPage}">
			<span><a class = "pagelist" href="list.sb?currentPage=${pv.startPage+pv.blockPage}">다음</a></span>
		</c:if>
	</div>

</body>
</html>







