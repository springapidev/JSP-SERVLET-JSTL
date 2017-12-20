<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Locale Display</title></head>
<body>
<h2>Here is your preferred locale info...</h2>

<c:set var="clientLocale" value="${pageContext.request.locale}" />
<c:set var="clientLocales" value="${pageContext.request.locales}" />

Preferred locale: ${clientLocale.displayName}
 <br />
Preferred locale country: ${clientLocale.displayCountry}
<br />
Preferred locale language: ${clientLocale.displayLanguage}
<h3>Lower priority locales...</h3>
<c:forEach var="loc" items="${clientLocales}" begin="1">
    Locale: ${loc.displayName}
    <br />
     Locale country: ${loc.displayCountry}
   <br />
    Locale language: ${loc.displayLanguage}
  <br /><br />
</c:forEach>

</body>
</html>
