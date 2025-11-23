package dam.m6.uf2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dam.m6.uf2.model.Deportista;

public class DeportistaDAO {

    private Connection conn;

    public DeportistaDAO(Connection conn) {
        this.conn = conn;
    }

    /** Añadir un deportista */
    public void agregarDeportista(Deportista dep) {
        String sql = "INSERT INTO deportistas (nombre, cod_deporte) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dep.getName());
            stmt.setInt(2, dep.getCodDeporte());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar deportista: " + e.getMessage());
        }
    }

    /** Buscar deportistas por nombre (coincidencia parcial) */
    public List<Deportista> buscarPorNombre(String nombre) {
        List<Deportista> lista = new ArrayList<>();

        String sql = "SELECT cod, nombre, cod_deporte FROM deportistas " +
                     "WHERE LOWER(nombre) LIKE LOWER(?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nombre + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Deportista(
                        rs.getInt("cod"),
                        rs.getString("nombre"),
                        rs.getInt("cod_deporte")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error en búsqueda por nombre: " + e.getMessage());
        }

        return lista;
    }

    /** Obtener deportistas según el ID del deporte usando llistaDeportistasDeSports() */
    public List<Deportista> obtenerDeportistasDeDeporte(int idDeporte) {
        List<Deportista> lista = new ArrayList<>();

        String sql = "SELECT * FROM llistaDeportistasDeSports(?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idDeporte);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Deportista(
                        rs.getInt("cod"),
                        rs.getString("nombre"),
                        rs.getInt("cod_deporte")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener deportistas de deporte: " + e.getMessage());
        }

        return lista;
    }
}
