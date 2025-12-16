package dam.m6.uf2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List; 

public class LlibreHibernate {
    
    public void insertar(Llibre llibre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(llibre);  // persist() es JPA/Hibernate recomendado
        tx.commit();
        session.close();
    }

    public void actualizar(Llibre llibre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(llibre);   // merge() actualiza o inserta si no existe
        tx.commit();
        session.close();
    }

    public void eliminar(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Llibre llibre = session.get(Llibre.class, id);
        if (llibre != null) {
            session.remove(llibre); // remove() reemplaza al antiguo delete()
        }
        tx.commit();
        session.close();
    }
    // 📄 Obtener todos los libros
    public List<Llibre> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Llibre> llibres = session.createQuery("from Llibre", Llibre.class).list();
        session.close();
        return llibres;
    }

        // 🔎 Buscar libro por ID
    public Llibre getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Llibre llibre = session.get(Llibre.class, id);
        session.close();
        return llibre;
    }

        // 🔎 Buscar libros por autor
    public List<Llibre> getByAuthor(String author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Llibre> llibres = session.createQuery(
                "from Llibre where author = :author", Llibre.class)
                .setParameter("author", author)
                .list();
        session.close();
        return llibres;
    }

        // 🔎 Buscar libros por título parcial
    public List<Llibre> getByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Llibre> llibres = session.createQuery(
                "from Llibre where title like :title", Llibre.class)
                .setParameter("title", "%" + title + "%")
                .list();
        session.close();
        return llibres;
    }

        // 🔃 Ordenar por título
    public List<Llibre> getOrderByTitle() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Llibre> llibres = session.createQuery(
                "from Llibre order by title", Llibre.class).list();
        session.close();
        return llibres;
    }
        // 🔃 Ordenar por autor
    public List<Llibre> getOrderByAuthor() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Llibre> llibres = session.createQuery(
                "from Llibre order by author", Llibre.class).list();
        session.close();
        return llibres;
    }

        // 🔢 Contar libros
    public long countLlibres() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Long count = session.createQuery(
                "select count(*) from Llibre", Long.class).uniqueResult();
        session.close();
        return count != null ? count : 0;
    }

        // 🧹 Borrar todos los libros
    public void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from Llibre").executeUpdate();
        tx.commit();
        session.close();
    }
}
