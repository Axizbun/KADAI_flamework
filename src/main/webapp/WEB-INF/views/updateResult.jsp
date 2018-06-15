<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新結果確認画面</title>
</head>
<body>
	<c:if test="${empty sessionScope.controller}">
		<c:redirect url= "index"/>
	</c:if>
	<p>実行者：${controller}</p>
	<p>正常に更新されました</p>
	<form:form action="selectIn" modelAttribute = "command">
		<form:button>検索</form:button>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>