<html>
  <head>
      <title>Professional JSP 2, 4th Edition</title>
      <link rel="stylesheet" href="projsp.css">
  </head>
  <body>

    <%@ taglib uri="/WEB-INF/tlds/ch06.tld" prefix="ch06" %>

    <h2>Thumbnails</h2>
    <table width="100%">
      <tr>
        <ch06:list path="/photos" suffix=".jpg">
          <td align="center">
            <img src=".${filename}" alt="${filename}" width="128" height="96">
          </td>
        </ch06:list>
      </tr>
    </table>

  </body>

</html>