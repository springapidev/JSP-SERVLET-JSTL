<%@ page language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/oscache" prefix="os"%>

<%-- ****************************************************************** --%>

<html>
<head>
	<style type="text/css"><jsp:include page="/ag.jsp" /></style>
	<title>Ag - RSS Newsreader and Aggregator</title>
</head>
<body bgcolor="#FFFFFF"> 	
	
<h2>Ag - RSS Newsreader and Aggregator</h2>
<hr />

<p>News Items from all users Subscriptions are aggregated below.</p>

<p>You may <a href="subs">login</a> to Manage your Subscriptions.</p>

<os:cache time="3600" key="${param.mode}" >

<c:choose> 
   <c:when test="${param.mode == 'popular'}" >
    
      <h2>Most Popular Newsfeed Items</h2>
      View: Popular | <a href="maincache?mode=recent">Recent</a>
      
      <c:set var="items" value="${ag.popularItems}" />
   </c:when>   
   <c:otherwise> 
   
      <h2>Recent Newsfeed Items</h2>
      View: <a href="maincache?mode=popular">Popular</a> | Recent
      
      <c:set var="items" value="${ag.recentItems}" />
   </c:otherwise>    
</c:choose> 

<c:forEach var="item" items="${items}">
    <c:url var="url" value="/ag/link">
    	<c:param name="link" value="${item.link}"/>
    </c:url>
    
	<h3><a href="${url}">${item.title}</a></h3>
	${item.description} <br />
	<b>Posted: ${item.time}, Hits: ${item.hits}</b>
	
</c:forEach>

</os:cache>

<hr />

</body>
</html>
