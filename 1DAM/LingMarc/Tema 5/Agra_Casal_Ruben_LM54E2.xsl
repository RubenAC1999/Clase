<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title> Calificaciones de la convocatoria de Junio </title>
                <style>
                    table {
                        border-style: outset;
                    }

                    tr, th, td {
                        border: 1px solid black;
                    }

                    td {
                        text-align: center;
                    }
                </style>
            </head>
            <body>
                <h1 style="color:red">Calificaciones de la convocatoria de Junio</h1>
                <table>
                    <tr style="background-color:#336699">
                        <th colspan="3"> Datos </th>
                        <th colspan="3"> Notas </th>
                    </tr>
                    <tr style="background-color:#6699CC">
                        <th> Nombres </th>
                        <th> Apellidos </th>
                        <th> Tareas </th>
                        <th> Cuestionarios </th>
                        <th> Examen </th>
                        <th> Final </th>
                    </tr>
                    <xsl:for-each select="/notas/alumno[@convocatoria = 'Junio']">
                        <tr style="background-color:#E0FFFF">
                            <td> <xsl:value-of select="nombre"/> </td>
                            <td> <xsl:value-of select="apellidos"/> </td>
                            <td> <xsl:value-of select="tareas"/> </td>
                            <td> <xsl:value-of select="cuestionarios"/> </td>
                            <td> <xsl:value-of select="examen"/> </td>
                            <xsl:choose>
                                <xsl:when test="final >= 9">
                                    <td style="color:green"> Sobresaliente </td>
                                </xsl:when>
                                <xsl:when test="final >= 7">
                                    <td style="color:green"> Notable </td>
                                </xsl:when>
                                <xsl:when test="final >= 6">
                                    <td style="color:green"> Bien </td>
                                </xsl:when>
                                <xsl:when test="final >= 5">
                                    <td style="color:green"> Suficiente </td>
                                </xsl:when>
                                <xsl:when test="final >= 0">
                                    <td style="color:red"> Suspenso </td>
                                </xsl:when>
                            </xsl:choose>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
