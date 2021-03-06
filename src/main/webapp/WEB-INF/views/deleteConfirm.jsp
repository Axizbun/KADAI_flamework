<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${empty sessionScope.controller}">
		<c:redirect url= "index"/>
	</c:if>
	<p>これでよろしいですか？</p>

	<form:form action="deleteConfirm" modelAttribute="command">
		ID<form:input path="id" value="${fn:escapeXml(deleteUser.user_id)}"  readonly = "true"/><br>
		名前<form:input path="name" value="${fn:escapeXml(deleteUser.user_name)}"  readonly = "true"/><br>
		TEL<form:input path="tel" value="${fn:escapeXml(deleteUser.telephone)}"  readonly = "true"/>
		<form:button>確認</form:button>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>
