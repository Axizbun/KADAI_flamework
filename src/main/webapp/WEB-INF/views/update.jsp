<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新画面</title>
<link href="${pageContext.request.contextPath}/css/commons.css"
	rel="stylesheet">
</head>
<body>
	<c:if test="${empty sessionScope.controller}">
		<c:redirect url= "index"/>
	</c:if>
	<p>
		更新を行うデータのIDを入力してください<br> <span class="required"></span>は必須です
	</p>
<c:if test="${not empty msg}">
	<div class = "message"><p><span class="required"></span>${msg}</p></div>
</c:if>
	<form:form action="updateInput" modelAttribute="command">
		<div>
			<span class="required"></span>ID:
			<form:input path="id" />
			<form:errors path="id" cssStyle="color: red" />
		</div>
		<div>
			<form:button>確認</form:button>
		</div>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>