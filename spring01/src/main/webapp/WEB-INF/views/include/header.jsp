<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- views/include/header.jsp -->
<!-- JSTL core tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 숫자나 날짜 형식 쓸 때 -->
<!-- 컨텍스트 경로 -->
<c:set var="path" value="${pageContext.request.contextPath}" />

<!-- 실습 개발할 땐 이게 좋은 듯 -->
<script src="${path}/include/jquery-3.2.1.min.js"></script>
<!-- <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script> -->