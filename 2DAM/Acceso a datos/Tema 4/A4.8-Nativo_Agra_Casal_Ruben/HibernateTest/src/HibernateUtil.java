import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure()
                    .addAnnotatedClass(entities.Sede.class)
                    .addAnnotatedClass(entities.Departamento.class)
                    .addAnnotatedClass(entities.Empleado.class)
                    .addAnnotatedClass(entities.DatosProfEmpleado.class)
                    .addAnnotatedClass(entities.ProyectoSede.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
