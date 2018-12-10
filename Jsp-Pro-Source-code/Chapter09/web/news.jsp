<%@ page language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<style type="text/css"><jsp:include page="/ag.jsp" /></style>
	<title>Ag - Read News</title>
</head>
<body bgcolor="#FFFFFF"> 	
	
<h1>Ag - Read news</h1>
<hr />

<p>
<a href="subs">Manage Subscriptions</a> |	
<b>Read News</b> |	
<a href="login">Change User <c:out value="[${user.name}]" /></a>
</p>

<c:if test="${ processMessage != '' }">
	<p><font color="green"><c:out value="${processMessage}" /></font></p>
</c:if>

<c:if test="${ processError != '' }">
	<p><font color="red"><c:out value="${processError}" /></font></p>
</c:if>

<h2>Run the aggregator</h2>

<form action="news" method="POST">
	<input type="submit" name="verb" value="Aggregate"/>
    Fetch latest RSS newsfeed titles for your subscriptions.
</form>	
	
<h2>Your subscriptions</h2>

<p>These are the news stories from the newsfeeds to which you have subscribed,
if you only see Names and URLs below, then run the aggregator to retrieve 
newsfeed story titles</p>

<c:forEach var="sub" items="${subs}">
	<p>
		<b>Newsfeed Name:</b>  <c:out value="${sub.name}"/>
		<b>URL:</b>   <c:out value="${sub.newsfeed.url}"/>
	</p>
    <p>
    	<ul>
    	<c:forEach var="item" items="${sub.newsfeed.items}">
			<li>
				<c:url value="${item.link}" var="url"/>
				<a href="<c:out value='${url}'/>"> <c:out value="${item.title}"/> </a>
			</li>
		</c:forEach>
		</ul>
	</p>
</c:forEach>
	
</body>
</html>
