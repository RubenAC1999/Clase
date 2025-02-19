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
        DatabaseManager dm = new DatabaseManager();
        EntityManager em = DatabaseManager.createEntityManager("dataPersistence");

        dm.showMenu(em);




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
