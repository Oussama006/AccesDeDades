package dam.m6.uf2;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dam.m6.uf2.model.Deportista;
import dam.m6.uf2.model.Sport;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Deportista.class).addAnnotatedClass(Sport.class).buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
