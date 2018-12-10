<%@ page language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <style type="text/css"><jsp:include page="/ag.jsp" /></style>
    <title>Ag - Manage Subscriptions</title>
  </head>

  <body bgcolor="#FFFFFF">
    <h1>Ag - Manage subscriptions</h1>
    <hr />
    <p>
    <b>Manage Subscriptions</b> |
      <a href="news">Read News</a> |
      <a href="login">Change User <c:out value="[${user.name}]" /></a>
    </p>

    <c:if test="${ processMessage != '' }">
      <p><font color="green"><c:out value="${processMessage}" /></font></p>
    </c:if>
    <c:if test="${ processError != '' }">
      <p><font color="red"><c:out value="${processError}" /></font></p>
    </c:if>

    <h3>Add a new subscription</h3>

    <form action="subs" method="POST">
      Name <input type="text" name="name" />
      Newsfeed URL <input type="text" name="url" size="40"/>
      <input type="submit" name="verb" value="Add"/>
    </form>

    <h2>Subscriptions</h2>

    <p>You are currently subscribed to these newsfeeds:</p>
    <c:forEach var="sub" items="${subs}">
      [<c:url value="subs" var="url">
      <c:param name="verb" value="Remove"/>
      <c:param name="remove" value="${sub.id}"/>
      <c:param name="subname" value="${sub.name}"/>
      </c:url>
      <a href="<c:out value='${url}'/>"> Remove </a> ]
      <b>Name:</b> <c:out value="${sub.name}"/>
      <b>URL:</b> <c:out value="${sub.newsfeed.url}"/> <br/>
    </c:forEach>
  </body>
</html>