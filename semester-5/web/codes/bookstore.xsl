<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <!-- template for the root element -->
  <xsl:template match="/books">
    <html>
      <body>
        <h2>book list</h2>
        <ul>
          <xsl:for-each select="book">
            <li>
              <b><xsl:value-of select="title"/></b>
              by <xsl:value-of select="author"/>
            </li>
          </xsl:for-each>
        </ul>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>
