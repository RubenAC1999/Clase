<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
    <html>
        <head>
            <meta charset="UTF-8"/>
            <title> EjercicioRepaso5.3 </title>
            <style type="text/css">
                table, th, td {
                    border: 1px solid blue;
                    border-collapse: collapse;
                }
            </style>
        </head>
        <body>
            <table>
                <caption> Discografía de Daft Punk </caption>
                <tr>
                    <th> Título </th>
                    <th> Ventas </th>
                    <th> Fecha de salida </th>
                </tr>
                <xsl:for-each select="//disco">
                <tr>
                        <td> <xsl:value-of select="titulo"/> </td>
                        <td> <xsl:value-of select="ventas"/> </td>
                        <td> <xsl:value-of select="lanzamiento/dia"/>-<xsl:value-of select="lanzamiento/mes"/>-<xsl:value-of select="lanzamiento/anho"/></td>
                </tr>
            </xsl:for-each>
            </table>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>