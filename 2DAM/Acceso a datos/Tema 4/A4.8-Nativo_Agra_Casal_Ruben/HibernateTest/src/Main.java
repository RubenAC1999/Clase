import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// Mapeando mediante XML
// Se sigue usando en algunos proyectos antiguos. Mejor opción si se quiere separar el mapeo del código

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // 1.1 Todos los empleados
            String hql = "FROM Empleado";
            List<Empleado> empleados = session.createQuery(hql, Empleado.class).list();
            System.out.println("----------- Lista de empleados -----------");
            empleados.forEach(System.out::println);

            // 1.2 Todos los departamentos
            hql = "FROM Departamento";
            List<Departamento> departamentos = session.createQuery(hql, Departamento.class).list();
            System.out.println("----------- Lista de departamentos -----------");
            departamentos.forEach(System.out::println);

            // 2.1 Nombres de sedes
            hql = "SELECT s.nombre FROM Sede s";
            List<String> nombresSedes = session.createQuery(hql, String.class).getResultList();
            System.out.println("----------- Nombres de sedes -----------");
            nombresSedes.forEach(System.out::println);

            // 2.2 Nombres de empleados
            hql = "SELECT e.nombre FROM Empleado e";
            List<String> nombresEmpleados = session.createQuery(hql, String.class).getResultList();
            System.out.println("----------- Nombres de empleados -----------");
            nombresEmpleados.forEach(System.out::println);

            // 2.3 Nombres de Proyectos
            hql = "SELECT p.nombre FROM Proyecto p";
            List<String> nombresProyectos = session.createQuery(hql, String.class).getResultList();
            System.out.println("----------- Nombres de proyectos -----------");
            nombresProyectos.forEach(System.out::println);


            // 3.1 Empleados where dni
            hql = "FROM Empleado e WHERE e.dni = :dni";
            List<Empleado> empleadosConDNI = session.createQuery(hql, Empleado.class).setParameter("dni", "12345678A").getResultList();
            System.out.println("----------- Nombres de Empleados WHERE DNI -----------");
            empleadosConDNI.forEach(System.out::println);

            // 3.2 Proyectos where fInicio
            hql = "FROM Proyecto p WHERE p.fInicio > :fInicio";
            Date fInicio = format.parse("2024-01-01");
            List<Proyecto> proyectosFechaInicio = session.createQuery(hql, Proyecto.class).setParameter("fInicio", fInicio).getResultList();
            System.out.println("----------- Nombres de Proyectos WHERE fInicio -----------");
            proyectosFechaInicio.forEach(System.out::println);

            // 3.3 Proyectos where fFin
            hql = "FROM Proyecto p WHERE p.fFin < :fFin";
            Date fFin = format.parse("2025-01-01");
            List<Proyecto> proyectosFechaFin = session.createQuery(hql, Proyecto.class).setParameter("fFin", fFin).getResultList();
            System.out.println("----------- Nombres de Proyectos WHERE fFin -----------");
            proyectosFechaFin.forEach(System.out::println);

            // 4.1 Nombres de sedes
            hql = "FROM Sede s";
            List<Sede> sedes = session.createQuery(hql, Sede.class).getResultList();
            System.out.println("----------- Nombres de Sedes -----------");
            sedes.forEach(System.out::println);

            // 4.2 Nombres de departamentos
            hql = "FROM Departamento d";
            List<Departamento> departamentoList = session.createQuery(hql, Departamento.class).getResultList();
            System.out.println("----------- Nombres de Departamentos -----------");
            departamentoList.forEach(System.out::println);







            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException(e);

        } finally {
            session.close();
        }
    }
}