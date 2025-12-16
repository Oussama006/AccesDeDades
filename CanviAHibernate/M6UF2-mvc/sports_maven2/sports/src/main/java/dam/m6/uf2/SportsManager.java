package dam.m6.uf2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dam.m6.uf2.model.Deportista;
import dam.m6.uf2.model.Sport;

public class SportsManager {

    public static void main(String[] args) {

        SportsView view = new SportsView();
        int op;

        do {
            op = view.menu();

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            switch (op) {

                case 1:
                    List<Sport> deportes = session
                            .createQuery("FROM Sport", Sport.class)
                            .list();
                    view.mostrarEsports(deportes);
                    break;

                case 2:
                    List<Sport> sports = session
                            .createQuery("FROM Sport", Sport.class)
                            .list();
                    view.mostrarEsports(sports);

                    int id = view.pedirIdDeporte();
                    Query<Deportista> q = session.createQuery(
                            "FROM Deportista d WHERE d.sport.cod = :id",
                            Deportista.class);
                    q.setParameter("id", id);
                    view.mostrarAtletas(q.list());
                    break;

                case 3:
                    Sport nuevo = view.esportForm();
                    session.persist(nuevo);
                    break;

                case 4:
                    List<Sport> lista = session
                            .createQuery("FROM Sport", Sport.class)
                            .list();
                    view.mostrarEsports(lista);

                    int sportId = view.pedirIdDeporte();
                    Sport sport = session.get(Sport.class, sportId);

                    String nombre = view.pedirNombreAtleta();
                    session.persist(new Deportista(nombre, sport));
                    break;

                case 5:
                    String buscar = view.pedirNombreAtleta();
                    Query<Deportista> res = session.createQuery(
                            "FROM Deportista d WHERE d.nombre LIKE :nombre",
                            Deportista.class);
                    res.setParameter("nombre", "%" + buscar + "%");
                    view.mostrarBusqueda(res.list());
                    break;
            }

            tx.commit();
            session.close();

        } while (op != 0);

        System.out.println("Fin programa.");
    }
}
