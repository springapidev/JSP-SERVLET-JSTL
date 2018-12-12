<?xml version="1.0"?>
<xsl:stylesheet version="1.0" 
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">

<html>
<body>
<h2>Our Current Book List</h2>
<table border="2">
  <tr>
    <!-- the header -->
    <td>title</td>
    <td>author</td>
    <td>isbn</td>
    <td>published</td>
    <td>publisher</td>
    <td>url</td>
  </tr>
  
  <xsl:for-each select="books/book">
    <tr>
      <td><b><xsl:value-of select="title"/></b></td> 
      <td><xsl:value-of select="author"/></td>
      <td><xsl:value-of select="isbn"/></td>
      <td><xsl:value-of select="published"/></td>
      <td><i><xsl:value-of select="publisher"/></i></td>
      <td><xsl:value-of select="url"/></td>
    </tr>
  </xsl:for-each>
</table>

</body>
</html>
</xsl:template>
</xsl:stylesheet>
