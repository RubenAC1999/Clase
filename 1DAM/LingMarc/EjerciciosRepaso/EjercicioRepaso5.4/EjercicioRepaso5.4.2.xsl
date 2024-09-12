<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
    <html>
        <head>
            <meta charset="UTF-8"/>
            <title> EjercicioRepaso5.4.2</title>
        </head>
        <body>
            <table>
                <caption> <h3>Calificaciones de la convocatoria de Junio</h3></caption>
                <tr>
                    <th colspan="3"> Datos </th>
                    <th colspan="3"> Notas </th>
                </tr>
                <tr>
                    <th> Nombres </th>
                    <th> Apellidos </th>
                    <th> Tareas </th>
                    <th> Cuestionarios </th>
                    <th> Examen </th>
                    <th> Final </th>
                </tr>
                <xsl:for-each select="//alumno[@convocatoria = 'Junio']">
                    <tr>
                        <td> <xsl:value-of select="nombre"/> </td>
                        <td> <xsl:value-of select="apellidos"/></td>
                        <td> <xsl:value-of select="tareas"/></td>
                        <td> <xsl:value-of select="cuestionarios"/></td>
                        <td> <xsl:value-of select="examen"/></td>
                        <xsl:choose>
                            <xsl:when test="final >= 9">
                                <td> Sobresaliente </td>
                            </xsl:when>
                            <xsl:when test="final >= 7">
                                <td> Notable </td>
                            </xsl:when>
                            <xsl:when test="final = 6">
                                <td> Bien </td>
                            </xsl:when>
                            <xsl:when test="final = 5">
                                <td> Suficiente </td>
                            </xsl:when>
                            <xsl:otherwise>
                                <td> Suspenso </td>
                            </xsl:otherwise>                       
                        </xsl:choose>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>