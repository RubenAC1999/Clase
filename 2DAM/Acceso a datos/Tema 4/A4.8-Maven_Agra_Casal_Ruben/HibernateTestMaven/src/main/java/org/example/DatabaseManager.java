package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class DatabaseManager {

    public static EntityManager createEntityManager(String persistence) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence);
            EntityManager em = emf.createEntityManager();

        return em;
    }

    public static int iniciarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gestor de base de datos");
        System.out.println("-----------------------------");
        System.out.println("1. Insertar nueva fila");
        System.out.println("2. Actualizar una fila");
        System.out.println("3. Borrar en una fila");
        System.out.println("4. Consultar");
        System.out.println("5. Salir");
        System.out.println("-----------------------------");
        System.out.println("Elija una opción: ");
        int opcion = scanner.nextInt();

        return opcion;
    }

    public static void showTables (EntityManager em){
        String sql = "SELECT table_name FROM information_schema.tables WHERE table_schema = database()";
        List<String> tablas = em.createNativeQuery(sql).getResultList();

        int indice = 1;
        for(String tabla : tablas) {
            System.out.println(indice++ +". " + tabla);

        }
    }

    public static void insertarSede (EntityManager em, String table) {
        Scanner scanner = new Scanner(System.in);
        String sql = "SHOW ALL COLUMNS";
        List<String> columns = em.createQuery(sql).getResultList();

        for(int i = 0; i < columns.size(); i++) {
            System.out.println("Introduzca datos para " + columns + ":");

        }
    }

}
