package org.example;

import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Inserción de datos utilizando mapeo mediante anotaciones JPA
// Lo que más se usa actualmente, más rápido y sencillo.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = DatabaseManager.createEntityManager("dataPersistence");
        int opcion = DatabaseManager.iniciarMenu();

        switch(opcion) {
            case 1 :
                System.out.println("Elija la tabla en la que desee operar");
                opcion = scanner.nextInt();

                DatabaseManager.showTables(em);
                break;
            case 2:  System.out.println(1);
            case 3: System.out.println(1);
            case 4: System.out.println(1);
            case 5: System.exit(0);
        }



        /*try {
            em.getTransaction().begin();


            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }*/
    }

}
