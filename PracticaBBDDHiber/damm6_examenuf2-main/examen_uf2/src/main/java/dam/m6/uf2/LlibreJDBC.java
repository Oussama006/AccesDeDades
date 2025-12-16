package dam.m6.uf2;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session; 

public class LlibreJDBC implements LlibreDAO {

    @Override
    public void insertar(String title, String author){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(new Llibre(title, author));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void actualizar(int id, String newTitle, String newAuthor){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Llibre llibre = session.get(Llibre.class, id);
        if(llibre != null){
            if(newTitle != null){
                llibre.setTitle(newTitle); 
            }
            if (newAuthor != null) {
                llibre.setAuthor(newAuthor);
            }
            session.update(llibre);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Llibre llibre = session.get(Llibre.class, id);
        if(llibre != null){
            session.delete(llibre);
        }
        session.getTransaction().commit();
        session.close();
    }

    // 📋 Obtener todos los libros
    @Override
    public List<Llibre> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Llibre> llibres = session.createQuery("from Llibre", Llibre.class).list();
        session.close();
        return llibres;
    }

  @Override
    public Llibre getLlibreById(int id) {
        // Busca un libro por ID
        Session session = HibernateUtil.getSessionFactory().openSession();
        Llibre llibre = session.get(Llibre.class, id);
        session.close();
        return llibre;
    }

    @Override
    public List<Llibre> getLlibresByAuthor(String author) {
        // Busca libros de un autor específico
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Llibre> llibres = session.createQuery("from Llibre where author = :author", Llibre.class)
                                     .setParameter("author", author)
                                     .list();
        session.close();
        return llibres;
    }
}