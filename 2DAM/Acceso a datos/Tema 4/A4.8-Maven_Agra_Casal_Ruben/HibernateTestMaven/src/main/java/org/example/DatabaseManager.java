package org.example;

import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DatabaseManager {
    private String[] options;
    private final static Scanner SCANNER = new Scanner(System.in);

    public DatabaseManager() {
        this.options = new String[]{
                "Departamento",
                "Empleado",
                "Datos profesionales",
                "Proyecto",
                "Proyecto - sede",
                "Sede",
                "Consulta sedes y departamentos",
                "Buscar departamentos de x sede",
                "Salir"};
    }


    public static EntityManager createEntityManager(String persistence) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence);
            EntityManager em = emf.createEntityManager();

        return em;
    }

    public void showMenu() throws ParseException {
        EntityManager em = createEntityManager("dataPersistence");
        System.out.println("-----------------------------");
        System.out.println("|  Gestor de base de datos  |");
        System.out.println("-----------------------------");

        for(int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "." + options[i]);
        }
        System.out.println("----------------------");
        System.out.println("Escoja la tabla con la que desee operar: ");
        int option = SCANNER.nextInt();

        switch(option) {
            case 1 -> departamentoOptions(em);
            case 2 -> empleadoOptions(em);
            case 3 -> datosProfesionalesOptions(em);
            case 4 -> proyectoOptions(em);
            case 5 -> proyectoSedeOptions(em);
            case 6 -> sedeOptions(em);
            case 7 -> consultaDepartamentosSedes(em);
            case 8 -> consultarDepartamentosSede(em);
            default -> System.exit(0);

        }
    }

    public int subMenu() {
        System.out.println("1. Insertar");
        System.out.println("2. Modificar");
        System.out.println("3. Eliminar");
        System.out.println("4. Consultar");
        System.out.println("5. Atrás");
        System.out.println("--------------------------");
        System.out.println("Seleccione una opción: ");
        int opcion = SCANNER.nextInt();
        SCANNER.nextLine();     // Scanner para que recoja el salto de línea

        return opcion;
    }


    public void sedeOptions(EntityManager em) throws ParseException {
        System.out.println("Opciones para la tabla Sede");
        System.out.println("----------------------------");
        switch(subMenu()) {
            case 1 -> insertarSede(em);
            case 2 -> modificarSede(em);
            case 3 -> eliminarSede(em);
            case 4 -> consultarSedes(em);
            case 5 -> showMenu();
        }
    }


    private void insertarSede(EntityManager em) throws ParseException {
        System.out.println("Introduzca el nombre de la sede (0 para salir): ");
        String nombre = SCANNER.nextLine();
        if (dataComprobation(nombre)) {
            showMenu();
        }

        Sede sede = new Sede();
        sede.setNombre(nombre);

        em.getTransaction().begin();
        em.persist(sede);
        em.getTransaction().commit();
        em.close();

        System.out.println("Sede insertada con éxito: " + sede.getId() + " | " + sede.getNombre());
        realizarOtraOperacion(em);
    }

    private void modificarSede(EntityManager em) throws ParseException {
        consultarSedes(em);
        System.out.println("Escriba el id de la sede a modificar (0 para salir): ");
        int id = SCANNER.nextInt();
        SCANNER.nextLine(); // Scanner para recojer el salto de línea
        if (dataComprobation(id)) {
            showMenu();
        }

        Sede sede = em.find(Sede.class, id);
        if(sede == null) {
            System.err.println("El id proporcionado no existe, saliendo del programa...");
            return;
        }

        System.out.println("Introduce el nuevo nombre de la sede (0 para salir): ");
        String nombre = SCANNER.nextLine();
        if (dataComprobation(nombre)) {
            showMenu();
        }

        em.getTransaction().begin();
        sede.setNombre(nombre);
        em.getTransaction().commit();
        System.out.println("Sede modificada correctamente.");
        System.out.println(sede);
        realizarOtraOperacion(em);
    }

    public void eliminarSede(EntityManager em) throws ParseException {
        consultarSedes(em);
        System.out.println("Escriba el id de la sede a eliminar (0 para salir): ");
        int id = SCANNER.nextInt();
        SCANNER.nextLine();
        if (dataComprobation(id)) {
            showMenu();
        }

        Sede sede = em.find(Sede.class, id);

        nullComprobation(sede, em);

        System.out.println("Sede detectada, seguro que deseas eliminar la siguiente sede? (s/n)");
        System.out.println(sede);
        String option = SCANNER.nextLine();

        if(option.equalsIgnoreCase("s")) {
            em.getTransaction().begin();
            em.remove(sede);
            em.getTransaction().commit();
            System.out.println("Sede eliminada correctamente.");
        } else {
            System.out.println("Volviendo al menú principal...");
            showMenu();
        }

        realizarOtraOperacion(em);

    }

    private static void consultarSedes(EntityManager em) {
        String hql = "FROM Sede ";
        List<Sede> listaSedes = em.createQuery(hql, Sede.class).getResultList();
        listaSedes.forEach(System.out::println);
    }

    public void departamentoOptions(EntityManager em) throws ParseException {
        System.out.println("Opciones para la tabla Departamento");
        System.out.println("----------------------------");
        switch(subMenu()) {
            case 1 -> insertarDepartamento(em);
            case 2 -> modificarDepartamento(em);
            case 3 -> eliminarDepartamento(em);
            case 4 -> consultarDepartamentos(em);
            case 5 -> showMenu();
        }
    }

    private void insertarDepartamento(EntityManager em) {
        try {
            System.out.println("Introduzca el nombre del nuevo departamento ('0' para salir): ");
            String nombre = SCANNER.nextLine();
            if (dataComprobation(nombre)) {
                showMenu();
            }

            System.out.println("Introduzca el id de una sede existente ('0' para salir): ");
            consultarSedes(em);
            int idSede = SCANNER.nextInt();
            if (dataComprobation(idSede)) {
                showMenu();
            }

            Sede sede = em.find(Sede.class, idSede);
            nullComprobation(sede, em);

            em.getTransaction().begin();
            em.persist(new Departamento(nombre, sede));
            em.getTransaction().commit();
            em.close();
            System.out.println("Departamento insertado correctamente.");
            SCANNER.nextLine();

            realizarOtraOperacion(em);


        } catch (DataException | ParseException dataEx) {
            System.err.println("Error al insertar los datos, vuelva a intentarlo\n" + dataEx.getMessage());
            insertarDepartamento(em);
        }
    }

    public void modificarDepartamento(EntityManager em) throws ParseException {
        consultarDepartamentos(em);
        System.out.println("Introduzca el id de un departamento existente (0 para salir): ");
        int id = SCANNER.nextInt();
        SCANNER.nextLine();

        if (dataComprobation(id)) {
            showMenu();
        }

        Departamento departamento = em.find(Departamento.class, id);

        nullComprobation(departamento, em);

        System.out.println("Introduzca el nombre nuevo para el departamento (0 para salir): ");
        String nombre = SCANNER.nextLine();

        if (dataComprobation(nombre)) {
            showMenu();
        }

        consultarSedes(em);
        System.out.println("Introduzca el id de una sede existente (0 para salir): ");
        int idSede = SCANNER.nextInt();

        if (dataComprobation(idSede)) {
            showMenu();
        }

        Sede sede = em.find(Sede.class, idSede);

        nullComprobation(sede, em);

        em.getTransaction().begin();
        departamento.setNombre(nombre);
        departamento.setSede(sede);
        em.getTransaction().commit();

        System.out.println("Departamento modificado correctamente.");
        System.out.println(departamento);
        SCANNER.nextLine();

        realizarOtraOperacion(em);
    }

    public void eliminarDepartamento(EntityManager em) throws ParseException {
        consultarDepartamentos(em);
        System.out.println("Introduzca el id del departamento que desee eliminar: ");
        int id = SCANNER.nextInt();
        SCANNER.nextLine();

        if (dataComprobation(id)) {
            showMenu();
        }

        Departamento departamento = em.find(Departamento.class, id);

        nullComprobation(departamento, em);

        System.out.println("Departamento detectado, seguro que desea eliminar el siguiente departamento?");
        System.out.println(departamento);
        String option = SCANNER.nextLine();

        if(option.equalsIgnoreCase("s")) {
            em.getTransaction().begin();
            em.remove(departamento);
            em.getTransaction().commit();
            System.out.println("Departamento eliminado correctamente.");
            realizarOtraOperacion(em);
        } else {
            System.out.println("Volviendo al menú principal...");
            showMenu();
        }
    }

    private void consultarDepartamentos(EntityManager em) {
        String hql = "FROM Departamento";
        List<Departamento> departamentos = em.createQuery(hql, Departamento.class).getResultList();
        departamentos.forEach(System.out::println);
    }

    public void empleadoOptions(EntityManager em) throws ParseException {
        System.out.println("Opciones para la tabla Empleado");
        System.out.println("----------------------------");
        switch(subMenu()) {
            case 1 -> insertarEmpleado(em);
            case 2 -> modificarEmpleado(em);
            case 3 -> eliminarEmpleado(em);
            case 4 -> consultarEmpleados(em);
            case 5 -> showMenu();
        }
    }

    public void insertarEmpleado(EntityManager em) throws ParseException {
        try {
            System.out.println("Introduzca el dni del nuevo empleado (0 para salir): ");
            String dni = SCANNER.nextLine();
            if (dataComprobation(dni)) {
                showMenu();
            }

            Empleado empleadoExistente = em.find(Empleado.class, dni);

            if(empleadoExistente != null) {
                System.err.println("El dni proporcionado ya existe en la base de datos.");
                System.out.println(empleadoExistente);
                System.out.println("Vuelva a intentarlo.");
                insertarEmpleado(em);
            }

            System.out.println("Introduzca el nombre del nuevo empleado (0 para salir): ");
            String nombre = SCANNER.nextLine();
            if (dataComprobation(nombre)) {
                showMenu();
            }

            System.out.println("Introduzca un id de departamento existente (0 para salir): ");
            consultarDepartamentos(em);
            int idDepartamento = SCANNER.nextInt();
            if (dataComprobation(idDepartamento)) {
                showMenu();
            }

            Departamento departamento = em.find(Departamento.class, idDepartamento);

            nullComprobation(departamento, em);

            Empleado empleado = new Empleado(dni, nombre, departamento);

            em.getTransaction().begin();
            em.persist(empleado);
            em.getTransaction().commit();
            em.close();

            System.out.println("Empleado introducido correctamente.");
            System.out.println(empleado);
            SCANNER.nextLine();
            realizarOtraOperacion(em);

        } catch (ConstraintViolationException sqlEx) {
            System.err.println("ERROR: DNI DUPLICADO");
            System.out.println("Volviendo al menú principal...");
            showMenu();
        } catch (DataException dataEx) {
            System.err.println("Error al introducir datos.\n " + dataEx.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);

        }
    }

    public void modificarEmpleado(EntityManager em) throws ParseException {
        consultarEmpleados(em);
        System.out.println("Introduzca el dni de un empleado existente (0 para salir): ");
        String dni = SCANNER.nextLine();

        if (dataComprobation(dni)) {
            showMenu();
        }

        Empleado empleado = em.find(Empleado.class, dni);

        nullComprobation(empleado, em);

        System.out.println("Introduzca el nombre nuevo del empleado (0 para salir): ");
        String nombre = SCANNER.nextLine();

        if (dataComprobation(nombre)) {
            showMenu();
        }

        consultarDepartamentos(em);
        System.out.println("Introduzca el id de un departamento existente (0 para salir : ");
        int departamentoId = SCANNER.nextInt();

        if (dataComprobation(departamentoId)) {
            showMenu();
        }

        Departamento departamento = em.find(Departamento.class, departamentoId);

        nullComprobation(departamento, em);

        em.getTransaction().begin();
        empleado.setDni(dni);
        empleado.setNombre(nombre);
        empleado.setDepartamento(departamento);
        em.getTransaction().commit();

        System.out.println("Empleado modificado correctamente.");
        System.out.println(empleado);
        SCANNER.nextInt();
        realizarOtraOperacion(em);

    }

    public void eliminarEmpleado(EntityManager em) throws ParseException {
        consultarEmpleados(em);
        System.out.println("Introduzca el dni del empleado que desee eliminar (0 para salir): ");
        String dni = SCANNER.nextLine();

        if (dataComprobation(dni)) {
            showMenu();
        }

        Empleado empleado = em.find(Empleado.class, dni);

        nullComprobation(empleado, em);

        System.out.println("Empleado detectado, seguro que desea eliminar el siguiente empleado?");
        System.out.println(empleado);
        String option = SCANNER.nextLine();

        if(option.equalsIgnoreCase("s")) {
            em.getTransaction().begin();
            em.remove(empleado);
            em.getTransaction().commit();
            System.out.println("Empleado eliminado correctamente.");
            realizarOtraOperacion(em);

        } else {
            System.out.println("Volviendo al menú principal...");
            showMenu();
        }
    }

    private void consultarEmpleados(EntityManager em) {
        String hql = "FROM Empleado";
        List<Empleado> empleados = em.createQuery(hql, Empleado.class).getResultList();
        empleados.forEach(System.out::println);
    }

    public void datosProfesionalesOptions(EntityManager em) throws ParseException {
        System.out.println("Opciones para la tabla DatosProfEmpleado");
        System.out.println("----------------------------");
        switch(subMenu()) {
            case 1 -> insertarDatosProfesionales(em);
            case 2 -> modificarDatosProfesionales(em);
            case 3 -> eliminarDatosProfesionales(em);
            case 4 -> consultarDatosProfesionales(em);
            case 5 -> showMenu();
        }
    }

    public void insertarDatosProfesionales(EntityManager em) {
        try {
            consultarEmpleados(em);
            System.out.println("Introduzca dni de un empleado existente (0 para salir): ");
            String dni = SCANNER.nextLine();

            Empleado empleado = em.find(Empleado.class, dni);

            nullComprobation(empleado, em);

            System.out.println("Introduzca una categoría (2 car, 0 para salir): ");
            String categoria = SCANNER.nextLine();
            if (dataComprobation(categoria)) {
                showMenu();
            }

            System.out.println("Introduzca el sueldo bruto anual (0 para salir): ");
            float sueldoBruto = SCANNER.nextInt();
            if (dataComprobation((int) sueldoBruto)) {
                showMenu();
            }

            DatosProfEmpleado datosProf = new DatosProfEmpleado(dni, categoria, sueldoBruto, empleado);


            em.getTransaction().begin();
            em.persist(datosProf);
            em.getTransaction().commit();
            em.close();

            System.out.println("Datos introducidos correctamente.");
            System.out.println(datosProf);
            SCANNER.nextLine();

            realizarOtraOperacion(em);
        } catch (Exception ex) {
            SCANNER.nextLine();
        }
    }

    public void modificarDatosProfesionales(EntityManager em) throws ParseException {
        consultarDatosProfesionales(em);
        System.out.println("Introduce el dni de un empleado existente (0 para salir): ");
        String dni = SCANNER.nextLine();

        if (dataComprobation(dni)) {
            showMenu();
        }

        DatosProfEmpleado empleado = em.find(DatosProfEmpleado.class, dni);

        nullComprobation(empleado, em);

        System.out.println("Introduzca la categoría nueva (2 car, 0 para salir): ");
        String categoria = SCANNER.nextLine();

        if (dataComprobation(categoria)) {
            showMenu();
        }

        System.out.println("Introduzca el sueldo bruto anual (0 para salir): ");
        float sueldoBruto = SCANNER.nextFloat();

        if (dataComprobation((int) sueldoBruto)) {
            showMenu();
        }

        em.getTransaction().begin();
        empleado.setCategoria(categoria);
        empleado.setSueldoBrutoAnual(sueldoBruto);
        em.getTransaction().commit();

        System.out.println("Datos profesionales modificados correctamente.");
        System.out.println(empleado);
        SCANNER.nextLine();

        realizarOtraOperacion(em);
    }

    public void eliminarDatosProfesionales(EntityManager em) throws ParseException {
        consultarDatosProfesionales(em);
        System.out.println("Introduzca el dni del empleado del que desea eliminar sus datos profesionales: ");
        String dni = SCANNER.nextLine();
        if (dataComprobation(dni)) {
            showMenu();
        }

        DatosProfEmpleado datosProfEmpleado = em.find(DatosProfEmpleado.class, dni);
        nullComprobation(datosProfEmpleado, em);

        Empleado empleado = em.find(Empleado.class, dni);
        datosProfEmpleado = empleado.getDatosProf();

        System.out.println("Datos detectados, seguro que desea eliminar los siguientes datos?");
        System.out.println(datosProfEmpleado);
        String option = SCANNER.nextLine();



        if(option.equalsIgnoreCase("s")) {
            empleado.setDatosProf(null);
            em.getTransaction().begin();
            em.remove(datosProfEmpleado);
            em.getTransaction().commit();
            System.out.println("Datos eliminados correctamente.");
            realizarOtraOperacion(em);
        } else {
            System.out.println("Volviendo al menú principal...");
            showMenu();
        }
    }

    private void consultarDatosProfesionales(EntityManager em) {
        String hql = "FROM DatosProfEmpleado";
        List<DatosProfEmpleado> datosProfesionales = em.createQuery(hql, DatosProfEmpleado.class).getResultList();
        datosProfesionales.forEach(System.out::println);
    }


    public void proyectoOptions (EntityManager em) throws ParseException {
        System.out.println("Opciones para la tabla Proyecto");
        System.out.println("----------------------------");
        switch(subMenu()) {
            case 1 -> insertarProyecto(em);
            case 2 -> modificarProyectos(em);
            case 3 -> eliminarProyectos(em);
            case 4 -> consultarProyectos(em);
            case 5 -> showMenu();
        }
    }

    public void insertarProyecto(EntityManager em) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            System.out.println("Introduzca fecha de inicio (formato: yyyy-MM-dd, 0 para salir): ");
            String fechaInicioStr = SCANNER.nextLine();
            if (dataComprobation(fechaInicioStr)) {
                showMenu();
            }

            Date fechaInicio = dateFormat.parse(fechaInicioStr);

            System.out.println("Está finalizado? (s/n)");
            String estaFinzalizado = SCANNER.nextLine();

            Date fechaFin = null;

            if (estaFinzalizado.equalsIgnoreCase("s")) {
                System.out.println("Introduzca fecha de finalización (formato: yyyy-MM-dd, 0 para salir): ");
                String fechaFinStr = SCANNER.nextLine();
                if (dataComprobation(fechaFinStr)) {
                        showMenu();
                    }

                fechaFin = dateFormat.parse(fechaFinStr);

                } else if (!estaFinzalizado.equalsIgnoreCase("n")) {
                System.err.println("Error al leer datos.");
                insertarProyecto(em);
            }

            System.out.println("Introduzca el nombre del nuevo proyecto (0 para salir): ");
            String nombreProyecto = SCANNER.nextLine();
            if (dataComprobation(nombreProyecto)) {
                showMenu();
            }

            Proyecto proyecto = new Proyecto(fechaInicio, fechaFin, nombreProyecto );

            em.getTransaction().begin();
            em.persist(proyecto);
            em.getTransaction().commit();
            em.close();
            System.out.println("Proyecto insertado correctamente.");
            System.out.println(proyecto);
            realizarOtraOperacion(em);


        } catch (Exception ex) {
            SCANNER.nextLine();
            System.err.println("Error al insertar datos");
            insertarProyecto(em);
        }
    }

    public void modificarProyectos(EntityManager em) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        consultarProyectos(em);
        System.out.println("Escriba el id de un proyecto existente (0 para salir): ");
        int id = SCANNER.nextInt();
        SCANNER.nextLine();

        if (dataComprobation(id)) {
            showMenu();
        }

        Proyecto proyecto = em.find(Proyecto.class, id);
        nullComprobation(proyecto, em);

        System.out.println("Escriba fecha de inicio (formato: yyyy-MM-dd, 0 para salir): ");
        String fechaInicioStr = SCANNER.nextLine();

        Date fechaInicio = dateFormat.parse(fechaInicioStr);

        System.out.println("Está finalizado? (s/n)");
        String estaFinzalizado = SCANNER.nextLine();

        Date fechaFin = null;

        if (estaFinzalizado.equalsIgnoreCase("s")) {
            System.out.println("Introduzca fecha de finalización (formato: yyyy-MM-dd, 0 para salir): ");
            String fechaFinStr = SCANNER.nextLine();
            if (dataComprobation(fechaFinStr)) {
                showMenu();
            }

            fechaFin = dateFormat.parse(fechaFinStr);

        } else if (!estaFinzalizado.equalsIgnoreCase("n")) {
            System.err.println("Error al leer datos.");
            insertarProyecto(em);
        }

        System.out.println("Introduzca el nombre del proyecto (0 para salir): ");
        String nombre = SCANNER.nextLine();

        em.getTransaction().begin();
        proyecto.setfInicio(fechaInicio);
        proyecto.setfFin(fechaFin);
        proyecto.setNombre(nombre);
        em.getTransaction().commit();

        System.out.println("Proyecto modificado correctamente.");
        System.out.println(proyecto);
        realizarOtraOperacion(em);
    }

    public void eliminarProyectos(EntityManager em) throws ParseException {
        consultarProyectos(em);
        System.out.println("Introduzca el id del proyecto que desea eliminar: ");
        int id = SCANNER.nextInt();
        SCANNER.nextLine();

        if (dataComprobation(id)) {
            showMenu();
        }

        Proyecto proyecto = em.find(Proyecto.class, id);

        nullComprobation(proyecto, em);

        System.out.println("Proyecto detectado, seguro que desea eliminar el siguiente proyecto?");
        System.out.println(proyecto);
        String option = SCANNER.nextLine();

        if(option.equalsIgnoreCase("s")) {
            em.getTransaction().begin();
            em.remove(proyecto);
            em.getTransaction().commit();
            System.out.println("Proyecto eliminado correctamente.");
            realizarOtraOperacion(em);
        } else {
            System.out.println("Volviendo al menú principal...");
            showMenu();
        }
    }


    private void consultarProyectos(EntityManager em) {
        String hql = "FROM Proyecto";
        List<Proyecto> proyectos = em.createQuery(hql, Proyecto.class).getResultList();
        proyectos.forEach(System.out::println);
    }


    public void proyectoSedeOptions (EntityManager em) throws ParseException {
        System.out.println("Opciones para la tabla Proyecto - Sede");
        System.out.println("----------------------------");
        switch(subMenu()) {
            case 1 -> insertarProyectoSede(em);
            case 2 -> proyectoSedeOptions(em);
            case 3 -> eliminarProyectoSede(em);
            case 4 -> consultarProyectosSedes(em);
            case 5 -> showMenu();

        }
    }

    public void insertarProyectoSede(EntityManager em) {
        try {
            consultarProyectos(em);
            System.out.println("Introduzca id de proyecto existente (0 para salir): ");
            int idProyecto = SCANNER.nextInt();
            if (dataComprobation(idProyecto)) {
                showMenu();
            }

            Proyecto proyecto = em.find(Proyecto.class, idProyecto);

            consultarSedes(em);
            System.out.println("Introduzca id de sede existente (0 para salir): ");
            int idSede = SCANNER.nextInt();
            if (dataComprobation(idSede)) {
                showMenu();
            }

            Sede sede = em.find(Sede.class, idSede);

            ProyectoSedeId id = new ProyectoSedeId(proyecto, sede);

            ProyectoSede proyectoSede = new ProyectoSede(id, sede, proyecto);

            em.getTransaction().begin();
            em.persist(proyectoSede);
            em.getTransaction().commit();
            em.close();

            System.out.println("Proyecto - Sede insertado correctamente.");
            System.out.println(proyectoSede);
            SCANNER.nextLine();
            realizarOtraOperacion(em);

        } catch (Exception ex) {
            SCANNER.nextLine();
            System.err.println("Error al insertar datos");
            System.err.println(ex.getMessage());
            insertarProyectoSede(em);
        }
    }

    public void eliminarProyectoSede(EntityManager em) throws ParseException {
        consultarProyectosSedes(em);
        System.out.println("Introduzca el id del proyecto (0 para salir): ");
        int idProyecto = SCANNER.nextInt();
        if (dataComprobation(idProyecto)) {
            showMenu();
        }

        System.out.println("Introduzca el id de la sede (0 para salir): ");
        int idSede = SCANNER.nextInt();
        SCANNER.nextLine();
        if (dataComprobation(idSede)) {
            showMenu();
        }

        Sede sede = em.find(Sede.class, idSede);
        Proyecto proyecto = em.find(Proyecto.class, idProyecto);
        ProyectoSedeId ids = new ProyectoSedeId(proyecto, sede);
        ProyectoSede proyectoSede = em.find(ProyectoSede.class, ids);

        nullComprobation(proyectoSede, em);

        System.out.println("Proyecto - Sede detectado, seguro que desea eliminar los siguientes datos?");
        System.out.println(proyectoSede);
        String option = SCANNER.nextLine();

        if(option.equalsIgnoreCase("s")) {
            em.getTransaction().begin();
            em.remove(proyectoSede);
            em.getTransaction().commit();
            System.out.println("Datos eliminados correctamente.");
            realizarOtraOperacion(em);
        } else {
            System.out.println("Volviendo al menú principal...");
            showMenu();
        }
    }


    private void consultarProyectosSedes(EntityManager em) {
        String hql = "FROM ProyectoSede";
        List<ProyectoSede> proyectosSedes = em.createQuery(hql, ProyectoSede.class).getResultList();
        proyectosSedes.forEach(System.out::println);
    }


    public void consultaDepartamentosSedes(EntityManager em) throws ParseException {
        String hql = "SELECT s.id, s.nombre, d.nombre FROM Departamento d JOIN d.sede s";
        List<Object[]> resultados = em.createQuery(hql, Object[].class).getResultList();

        System.out.println("Lista de sedes y departamentos donde se ubican:");

        for (Object[] fila : resultados) {
            Integer idSede = (Integer) fila[0];
            String nombreSede = (String) fila[1];
            String nombreDepto = (String) fila[2];
            System.out.println("ID Sede: " + idSede + " | Nombre Sede: " + nombreSede + " | Nombre Departamento: " + nombreDepto);
        }
        SCANNER.nextLine();


        realizarOtraOperacion(em);
    }


    public void consultarDepartamentosSede(EntityManager em) throws ParseException {
        SCANNER.nextLine();
        consultarSedes(em);
        System.out.println("Introduzca el nombre de una sede existente: ");
        String nombreSedeExistente = SCANNER.nextLine();

        String hql = "SELECT s.id, s.nombre, d.nombre " +
                "FROM Departamento d JOIN d.sede s " +
                "WHERE s.nombre = :nombreSede";

        List<Object[]> resultados = em.createQuery(hql, Object[].class)
                .setParameter("nombreSede", nombreSedeExistente)
                .getResultList();

        for (Object[] fila : resultados) {
            Integer idSede = (Integer) fila[0];
            String nombreSede = (String) fila[1];
            String nombreDepto = (String) fila[2];
            System.out.println("ID Sede: " + idSede + " | Nombre Sede: " + nombreSede + " | Nombre Departamento: " + nombreDepto);
        }


        realizarOtraOperacion(em);

    }



    public boolean dataComprobation(String data) {
    if (data.equals("0")) {
        System.err.println("Operación cancelada.");
        System.out.println("Volviendo al menú principal");
        return true;
    }
    return false;
}

public boolean dataComprobation(int data) {
        if (data == 0) {
            System.err.println("Operación cancelada.");
            System.out.println("Volviendo al menú principal");
            return true;
        }

        return false;
}

public void nullComprobation(Object obj, EntityManager em) throws ParseException {
        if(obj == null) {
            System.err.println("ERROR: El id introducido no existe, volviendo al menú principal...");
            showMenu();
        }


}

public void realizarOtraOperacion(EntityManager em) throws ParseException {
        System.out.println("Desea realizar otra operacion? (s/n): ");
        String option = SCANNER.nextLine();
        if (option.equalsIgnoreCase("s")) {
            showMenu();
        } else {
            System.err.println("Saliendo del programa...");
            System.exit(0);
        }
}


    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}
