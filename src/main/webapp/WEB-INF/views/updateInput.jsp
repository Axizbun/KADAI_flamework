<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容入力画面</title>
<link href="/css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${empty sessionScope.controller}">
		<c:redirect url= "index"/>
	</c:if>
	<p>
		１箇所以上の項目を変更してください<br> <span class="required"></span>IDは変更できません
	</p>

	<c:if test="${not empty msg}">
		<div class="message">
			<p class = "required">${error}</p>
		</div>
	</c:if>

	<form:form action="updateConfirm" modelAttribute="command">
		<fieldset>
			<div>
				<label>ID</label><form:input path = "id" value="${beforeUser.user_id}" readonly = "true"/>
			</div>
			<div>
				<label>名前</label><form:input path = "newName" value="${beforeUser.user_name}" />
			</div>
			<div>
				<label>TEL</label><form:input path="newTel" value="${beforeUser.telephone}" />
			</div>
			<div>
				<label>PASS</label><form:password path = "newPass" value="${beforeUser.password}"/>
			</div>
		</fieldset>
		<div>
			<form:button>確認</form:button>
			<input type="submit" name="button" value="戻る" onclick="location.href='update'; return false;">
		</div>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>