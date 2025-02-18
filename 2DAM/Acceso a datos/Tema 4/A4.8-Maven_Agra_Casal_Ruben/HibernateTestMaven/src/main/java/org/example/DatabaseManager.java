package org.example;

import entities.Departamento;
import entities.Sede;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

    public int showMenu() {
        System.out.println("Gestor de base de datos");
        System.out.println("--------------------------");

        for(int i = 1; i < options.length; i++) {
            System.out.println(i + "." + options[i]);
        }
        System.out.println("----------------------");
        System.out.println("Escoja la tabla con la que desee operar: ");

        return SCANNER.nextInt();
    }



    public int subMenu() {
        System.out.println("1. Insertar");
        System.out.println("2. Modificar");
        System.out.println("3. Eliminar");
        System.out.println("4. Consultar");
        System.out.println("5. Atrás");
        System.out.println("--------------------------");
        System.out.println("Seleccione una opción: ");
        return SCANNER.nextInt();
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


    private static void insertarSede(EntityManager em) {

        System.out.println("Introduzca el nombre de la sede:");
        String nombre = SCANNER.nextLine();

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
            case 1 -> insertarSede(em);
            case 2 -> System.out.println(2); // Método a implementar
            case 3 -> System.out.println(3); // Método a implementar
            case 4 -> System.out.println(4); // Método a implementar
        }
    }

    private void insertarDepartamento(EntityManager em) {
        System.out.println("Introduzca el nombre del nuevo departamento: ");
        String nombre = SCANNER.nextLine();

        System.out.println("Introduzca el id de una sede existente");
        consultarSedes(em);
        int idSede = SCANNER.nextInt();

        Sede sede = em.find(Sede.class, idSede);

        em.getTransaction();
        em.persist(new Departamento(nombre, sede));
        em.getTransaction().commit();
        em.close();
    }





    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}
