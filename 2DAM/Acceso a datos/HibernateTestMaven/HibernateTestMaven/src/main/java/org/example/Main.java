package org.example;

// Mapeando mediante XML (hbm.xml)
// Para proyectos antiguos,

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println(sessionFactory);
            System.out.println("Conexión realizada con éxito");
        } catch (Throwable ex) {
            System.out.println("error");
            ex.printStackTrace();
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
                System.out.println("Sesión finalizada.");

            }
        }
    }
}
