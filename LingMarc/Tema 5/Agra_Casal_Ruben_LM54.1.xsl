<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="3.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">

<html>
    <head>
        <meta charset="UTF-8"/>
        <title> Inventario </title>
        <style>
            table, tr, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <xsl:if test="/inventario/producto[lugar[@edificio = 'A']]">
            <h1> Edificio <xsl:value-of select="distinct-values(//lugar[@edificio = 'A']/@edificio)"/></h1>
            <table>
                <xsl:for-each select="/inventario/producto[lugar[@edificio = 'A']]">
                    <tr>
                        <td> <xsl:value-of select="nombre"/></td>
                        <xsl:choose>
                            <xsl:when test="peso[@unidad = 'g']">
                                <td> <xsl:value-of select="peso div 1000"/> kg</td>
                            </xsl:when>
                            <xsl:otherwise>
                                <td> <xsl:value-of select="peso"/> kg</td>
                            </xsl:otherwise>
                        </xsl:choose>
                        <!-- En caso de haber más unidades de medida, habría que añadir otro "when"-->

                        <td> <xsl:value-of select="lugar/@edificio"/><xsl:value-of select="lugar/aula"/></td>
                    </tr>
                </xsl:for-each>
            </table>
        </xsl:if>

        <xsl:if test="/inventario/producto[lugar[@edificio = 'B']]">
            <h1> Edificio <xsl:value-of select="distinct-values(//lugar[@edificio = 'B']/@edificio)"/></h1>
            <table>
                <xsl:for-each select="/inventario/producto[lugar[@edificio = 'B']]">
                    <tr>
                        <td> <xsl:value-of select="nombre"/></td>
                        <xsl:choose>

                            <xsl:when test="peso[@unidad = 'g']">
                                <td> <xsl:value-of select="peso div 1000"/> kg</td>
                            </xsl:when>

                            <xsl:otherwise>
                                <td> <xsl:value-of select="peso"/> kg</td>
                            </xsl:otherwise>
                        </xsl:choose>
                         <!-- En caso de haber más unidades de medida, habría que añadir otro "when"-->
                         
                        <td> <xsl:value-of select="lugar/@edificio"/><xsl:value-of select="lugar/aula"/></td>
                    </tr>
                </xsl:for-each>
            </table>
        </xsl:if>
    </body>
</html>
</xsl:template>
</xsl:stylesheet>