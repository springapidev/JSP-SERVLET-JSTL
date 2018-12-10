<%@ page language="java"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<style type="text/css"><jsp:include page="/ag.jsp" /></style>
	<title>Ag - Login</title>
</head>

<body bgcolor="#FFFFFF"> 	
	
<h1>Ag - Login</h1>
<hr />

<c:if test="${ processMessage != '' }">
	<font color="green"><c:out value="${processMessage}" /></font><br>
</c:if>

<c:if test="${ processError != '' }">
	<font color="red"><c:out value="${processError}" /></font><br>
</c:if>

<p>Welcome to the Ag RSS Newsreader. Please login.</p>

<form action="login" method="POST">
	Name <input type="text" name="userName" />
	<input type="submit" name="verb" value="Login"/>
</form>	

</body>
</html>
