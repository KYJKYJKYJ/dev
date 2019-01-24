<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
[
<c:if test="${!empty tabList}">
<c:forEach items="${tabList}" var="dto" varStatus="status">
	<c:if test="${status.index>0}">,</c:if>
	<c:choose>
		<c:when test="${param.gubun=='employees'}">
		{"employee_id":"${dto.employee_id}","first_name":"${dto.first_name}","hire_date":"${dto.hire_date}"}
		</c:when>		
		<c:when test="${param.gubun=='board'}">
		{"num":"${dto.num}","subject":"${dto.subject}","reg_date":"${dto.reg_date}"}
		</c:when>
		<c:otherwise>
		{"num":"${dto.num}","age":"${dto.age}","name":"${dto.name}"}
		</c:otherwise>			
	</c:choose>	
</c:forEach>
</c:if>
]