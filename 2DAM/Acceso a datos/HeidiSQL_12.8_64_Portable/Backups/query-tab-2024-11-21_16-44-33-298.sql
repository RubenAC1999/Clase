SELECT e.dni, e.nom_emp, d.nom_depto, s.nom_sede, p.categoria, p.sueldo_bruto_anual 

FROM empleado e 

JOIN departamento d ON e.id_depto = d.id_depto 

JOIN sede s ON d.id_sede = s.id_sede

JOIN empleado_datos_prof p ON e.dni = p.dni;