package dam.m6.uf2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dam.m6.uf2.model.Sport;

public class SportDAO implements DAO<Sport> {

    private Connection conn;

    public SportDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Añadir un deporte
     */
    @Override
    public void add(Sport deporte) {
        String sql = "INSERT INTO deportes (nombre) VALUES (?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, deporte.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar deporte: " + e.getMessage());
        }
    }

    @Override
    public List<Sport> getAll() {
        List<Sport> lista = new ArrayList<>();

        String sql = "SELECT * FROM llistaSports()";

        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Sport(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener lista de deportes: " + e.getMessage());
        }

        return lista;
    }
}
