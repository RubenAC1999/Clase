<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
    <html>
        <head>
            <meta charset="UTF-8"/>
            <title> EjercicioRepaso5.4.1 </title>
        </head>
        <body>
            <xsl:if test="/inventario/producto/lugar/@edificio = 'A'">
                <h1> Edificio A</h1>
                    <table>
                        <xsl:for-each select="//producto/lugar[@edificio = 'A']">
                            <tr>
                                <td> <xsl:value-of select="../nombre"/></td>
                                <td> <xsl:value-of select="../peso"/> kg</td>
                                <td> <xsl:value-of select="@edificio"/><xsl:value-of select="aula"/></td>
                            </tr>
                        </xsl:for-each>
                    </table>
            </xsl:if>
            <xsl:if test="/inventario/producto/lugar/@edificio = 'B'">
            <h1> Edificio B</h1>
                <table>
                    <xsl:for-each select="//producto/lugar[@edificio = 'B']">
                        <tr>
                            <td> <xsl:value-of select="../nombre"/></td>
                            <xsl:choose>
                                <xsl:when test="../peso/@unidad = 'g'">
                                    <td> <xsl:value-of select="../peso div 1000"/> kg </td>
                                </xsl:when>
                                <xsl:otherwise>
                                    <td> <xsl:value-of select="../peso"/> kg </td>
                                </xsl:otherwise>
                            </xsl:choose>
                            <td> <xsl:value-of select="@edificio"/><xsl:value-of select="aula"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
        </xsl:if>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>