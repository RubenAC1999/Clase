package org.example;

import entities.Departamento;
import entities.Empleado;
import entities.Sede;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.PropertyValueException;
import org.hibernate.exception.DataException;
import org.hibernate.mapping.Property;

import java.util.ArrayList;
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
                "Atrás"};
    }


    public static EntityManager createEntityManager(String persistence) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence);
            EntityManager em = emf.createEntityManager();

        return em;
    }

    public void showMenu(EntityManager em) {
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
            case 3 -> System.out.println("Selección de opción 3.");
            case 4 -> System.out.println("Selección de opción 4.");
            case 5 -> System.out.println("Selección de opción 5");
            case 6 -> sedeOptions(em);
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


    public void sedeOptions(EntityManager em) {
        System.out.println("Opciones para la tabla Sede");
        System.out.println("----------------------------");
        switch(subMenu()) {
            case 1 -> insertarSede(em);
            case 2 -> System.out.println(2); // Método a implementar
            case 3 -> System.out.println(3); // Método a implementar
            case 4 -> System.out.println(4); // Método a implementar
        }
    }


    private void insertarSede(EntityManager em) {
        System.out.println("Introduzca el nombre de la sede (0 para salir): ");
        String nombre = SCANNER.nextLine();
        if (dataComprobation(nombre)) {
            showMenu(em);
        }

        Sede sede = new Sede();
        sede.setNombre(nombre);

        em.getTransaction().begin();
        em.persist(sede);
        em.getTransaction().commit();
        em.close();

        System.out.println("Sede insertada con éxito: " + sede.getId() + " | " + sede.getNombre());
    }

    private static void consultarSedes(EntityManager em) {
        String hql = "FROM Sede ";
        List<Sede> listaSedes = em.createQuery(hql, Sede.class).getResultList();
        listaSedes.forEach(System.out::println);
    }

    public void departamentoOptions(EntityManager em) {
        System.out.println("Opciones para la tabla Departamento");
        System.out.println("----------------------------");
        switch(subMenu()) {
            case 1 -> insertarDepartamento(em);
            case 2 -> System.out.println(2); // Método a implementar
            case 3 -> System.out.println(3); // Método a implementar
            case 4 -> System.out.println(4); // Método a implementar
        }
    }

    private void insertarDepartamento(EntityManager em) {
        try {
            System.out.println("Introduzca el nombre del nuevo departamento ('0' para salir): ");
            String nombre = SCANNER.nextLine();
            if (dataComprobation(nombre)) {
                showMenu(em);
            }

            System.out.println("Introduzca el id de una sede existente ('0' para salir): ");
            consultarSedes(em);
            int idSede = SCANNER.nextInt();
            if (dataComprobation(idSede)) {
                showMenu(em);
            }

            Sede sede = em.find(Sede.class, idSede);

            em.getTransaction().begin();
            em.persist(new Departamento(nombre, sede));
            em.getTransaction().commit();
            em.close();
            System.out.println("Departamento insertado correctamente.");

        } catch (PropertyValueException ex) {
            System.err.println("El id de la sede proporcionado no existe, vuelva a intentarlo." + ex.getMessage());
            insertarDepartamento(em);
        } catch (DataException dataEx) {
            System.err.println("Error al insertar los datos, vuelva a intentarlo\n" + dataEx.getMessage());
            insertarDepartamento(em);
        }
    }

    private void consultarDepartamentos(EntityManager em) {
        String hql = "FROM Departamento";
        List<Departamento> departamentos = em.createQuery(hql, Departamento.class).getResultList();
        departamentos.forEach(System.out::println);
    }

    public void empleadoOptions(EntityManager em) {
        System.out.println("Opciones para la tabla Empleado");
        System.out.println("----------------------------");
        switch(subMenu()) {
            case 1 -> insertarEmpleado(em);
            case 2 -> System.out.println(2); // Método a implementar
            case 3 -> System.out.println(3); // Método a implementar
            case 4 -> System.out.println(4); // Método a implementar
        }
    }

    public void insertarEmpleado(EntityManager em) {
        try {
            System.out.println("Introduzca el dni del nuevo empleado (0 para salir): ");
            String dni = SCANNER.nextLine();
            if (dataComprobation(dni)) {
                showMenu(em);
            }

            System.out.println("Introduzca el nombre del nuevo empleado: ");
            String nombre = SCANNER.nextLine();
            if (dataComprobation(nombre)) {
                showMenu(em);
            }

            System.out.println("Introduzca un id de departamento existente: ");
            consultarDepartamentos(em);
            int idDepartamento = SCANNER.nextInt();
            if (dataComprobation(idDepartamento)) {
                showMenu(em);
            }

            Departamento departamento = em.find(Departamento.class, idDepartamento);

            em.getTransaction().begin();
            em.persist(new Empleado(dni, nombre, departamento));
            em.getTransaction().commit();
            em.close();
        } catch (PropertyValueException propEx) {
            System.err.println("El id del departamento proporcionado no existe, vuelva a intentarlo.");
            insertarEmpleado(em);
        } catch (DataException dataEx) {
            System.err.println("Error al introducir datos.\n " + dataEx.getMessage());
        }
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


    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}
