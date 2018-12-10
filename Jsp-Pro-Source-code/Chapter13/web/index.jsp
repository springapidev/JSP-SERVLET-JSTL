<html>
  <head>
    <title>Professional JSP 2, 4th Edition - Chapter 13, Performance</title>
    <link rel="stylesheet" href="projsp.css">
  </head>
  <body>
		<h2>Chapter 13 - Performance</h2>
		<hr />
		
    The page <a href="longop.jsp">longop.jsp</a> is not
    cached, so it will always take 10 seconds to load.</p>

    The page <a href="longop-cached.jsp">longop-cached.jsp</a>
    is cached, so the first time will take 10 seconds to
    load, but accesses within the cache time will load more
    quickly.</p>

    The page <a href="threesec.jsp">threesec.jsp</a>
    is a jsp with a three second sleep. It is intended
    as a test page to use with 
    <a href="http://jakarta.apache.org/jmeter/index.html">JMeter</a></p>

    The page <a href="threesec-single.jsp">threesec-single.jsp</a>
    is a jsp with a three second sleep that is single-threaded. It is 
    intended as a test page to use with 
    <a href="http://jakarta.apache.org/jmeter/index.html">JMeter</a></p>

    The <a href="index_rss.jsp">RSS Aggregator and NewsReader</a>
    with a new front page that accesses news items when loaded. This 
    page is also intended to demonstrate how to use caching to improve
    performance</p>
  </body>
</html>
