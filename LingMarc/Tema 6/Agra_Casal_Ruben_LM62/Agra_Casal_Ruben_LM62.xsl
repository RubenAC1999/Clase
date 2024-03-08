<xsl:stylesheet version="2.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
<html>
    <head>
        <meta charset="UTF-8"/>
        <title> Biblioteca </title>
        <style type="text/css">
            table, tr, th,td {
                border: 1px solid black;
            }

            td {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <table>
            <caption> LIBROS </caption>
            <tr>
                <th colspan="2"> Autor </th>
                <th colspan="4"> Libro </th>
            </tr>
            <tr>
                <th> Nombre </th>
                <th> Apellidos </th>
                <th> Título </th>
                <th> Editorial </th>
                <th> nº Páginas</th>
                <th> Edición electrónica </th>
            </tr>
            <xsl:for-each select="//autor">
                <xsl:sort select="apellidos"/>
                <tr>
                    <td> <xsl:value-of select="nombre"/></td>
                    <td> <xsl:value-of select="apellidos"/></td>
                    <td> <xsl:value-of select="../titulo"/></td>
                    <td> <xsl:value-of select="../editorial"/></td>
                    <td> <xsl:value-of select="../paginas"/></td>
                    <td> <xsl:value-of select="../edicionElectronica"/></td>
                </tr>
            </xsl:for-each>
        </table>
    </body>
</html>
</xsl:template>
</xsl:stylesheet>