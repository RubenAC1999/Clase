package org.example;

import jakarta.persistence.EntityManager;

import java.text.ParseException;

// Inserción de datos utilizando mapeo mediante anotaciones JPA
// Lo que más se usa actualmente, más rápido y sencillo.

public class Main {
    public static void main(String[] args) throws ParseException {
        DatabaseManager dm = new DatabaseManager();
        EntityManager em = DatabaseManager.createEntityManager("dataPersistence");

        dm.showMenu(em);
    }

}
