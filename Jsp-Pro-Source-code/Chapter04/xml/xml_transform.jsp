<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<c:import url="books.xml" var="books" />
<c:import url="books.xsl" var="xslt" />
<x:transform xml="${books}" xslt="${xslt}"/>