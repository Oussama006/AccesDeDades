package dam.m6.uf2;

import java.sql.Connection;
import java.util.List;

import dam.m6.uf2.model.Deportista;

public class SportsManager {

    public static void main(String[] args) {

        Connection conn = ConnectionManager.openConnection();

        SportDAO sportDAO = new SportDAO(conn);
        DeportistaDAO deportistaDAO = new DeportistaDAO(conn);
        SportsView view = new SportsView();

        int op;

        do {
            op = view.menu();

            switch (op) {
                case 1:
                    view.mostrarEsports(sportDAO.listarDeportes());
                    break;

                case 2:
                    view.mostrarEsports(sportDAO.listarDeportes());
                    int id = view.pedirIdDeporte();
                    view.mostrarAtletas(deportistaDAO.listarPorDeporte(id));
                    break;

                case 3:
                    sportDAO.add(view.esportForm());
                    break;

                case 4:
                    view.mostrarEsports(sportDAO.listarDeportes());
                    deportistaDAO.add(view.atletaForm(sportDAO.listarDeportes()));
                    break;

                case 5:
                    String nombre = view.pedirNombreAtleta();
                    List<Deportista> resultados = deportistaDAO.buscarPorNombre(nombre);
                    view.mostrarBusqueda(resultados);
                    break;
            }

        } while (op != 0);

        System.out.println("Fin programa.");
    }
}
