<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
<link href="${pageContext.request.contextPath}/css/commons.css"
	rel="stylesheet">
</head>
<body>
	<c:if test="${empty sessionScope.controller}">
		<c:redirect url= "index"/>
	</c:if>
	<p>
		登録情報を入力してください<br> <span class="required"></span>は必須です
	</p>

	<c:if test="${not empty msg}">
		<div class="message">
			<p class="required">${msg}</p>
		</div>
	</c:if>
	<form:form action="insert" modelAttribute="command">
		<fieldset class="label-60">
			<div>
				<label class="required">名前</label><form:input path="name" />
			</div>
			<div>
				<label class="required">TEL</label><form:input path="tel" />
			</div>
			<div>
				<label class="required">PASS</label><form:password path="pass" />
			</div>
		</fieldset>
		<form:button>確認</form:button>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>