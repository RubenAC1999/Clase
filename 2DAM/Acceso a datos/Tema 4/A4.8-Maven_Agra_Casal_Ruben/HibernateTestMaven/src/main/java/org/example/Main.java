package org.example;

import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

// Inserción de datos utilizando mapeo mediante anotaciones JPA
// Lo que más se usa actualmente, más rápido y sencillo.

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataPersistence");
        EntityManager em = emf.createEntityManager();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            em.getTransaction().begin();

            // 1.1 Todos los empleados
            String hql = "FROM Empleado";
            List<Empleado> empleados = em.createQuery(hql, Empleado.class).getResultList();
            System.out.println("----------- Lista de empleados -----------");
            empleados.forEach(System.out::println);


            // 1.2 Todos los departamentos
            hql = "FROM Departamento";
            List<Departamento> departamentos = em.createQuery(hql, Departamento.class).getResultList();
            System.out.println("----------- Lista de departamentos -----------");
            departamentos.forEach(System.out::println);

            // 2.1 Nombres de sedes
            hql = "SELECT s.nombre FROM Sede s";
            List<String> nombresSedes = em.createQuery(hql, String.class).getResultList();
            System.out.println("----------- Nombres de sedes -----------");
            nombresSedes.forEach(System.out::println);

            // 2.2 Nombres de empleados
            hql = "SELECT e.nombre FROM Empleado e";
            List<String> nombresEmpleados = em.createQuery(hql, String.class).getResultList();
            System.out.println("----------- Nombres de empleados -----------");
            nombresEmpleados.forEach(System.out::println);

            // 2.3 Nombres de proyectos
            hql = "Select p.nombre FROM Proyecto p";
            List<String> nombresProyectos = em.createQuery(hql, String.class).getResultList();
            System.out.println("----------- Nombres de proyectos -----------");
            nombresProyectos.forEach(System.out::println);

            // 3.1 Empleados where dni
            hql = "FROM Empleado e WHERE e.dni = :dni";
            List<Empleado> empleadosConDNI = em.createQuery(hql, Empleado.class).setParameter("dni", "12345678A").getResultList();
            System.out.println("----------- Nombres de Empleados WHERE DNI -----------");
            empleadosConDNI.forEach(System.out::println);

            // 3.2 Proyectos where fecha inicio
            hql = "FROM Proyecto p WHERE p.fInicio > :fInicio";
            Date fInicio = format.parse("2024-01-01");
            List<Proyecto> proyectosFechaInicio = em.createQuery(hql, Proyecto.class).setParameter("fInicio", fInicio).getResultList();
            System.out.println("----------- Nombres de Empleados WHERE Fecha inicio -----------");
            proyectosFechaInicio.forEach(System.out::println);





            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
