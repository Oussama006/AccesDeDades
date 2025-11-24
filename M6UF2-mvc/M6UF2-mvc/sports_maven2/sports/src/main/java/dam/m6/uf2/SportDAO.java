package dam.m6.uf2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dam.m6.uf2.model.Sport;

public class SportDAO {

    private Connection conn;

    public SportDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Sport> listarDeportes() {
        List<Sport> lista = new ArrayList<>();

        String sql = "SELECT * FROM llistaSports()";

        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Sport(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error listar deportes: " + e.getMessage());
        }

        return lista;
    }

    public void add(Sport s) {
        String sql = "INSERT INTO deportes(nombre) VALUES (?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getNombre());
            ps.executeUpdate();
            System.out.println("Deporte añadido.");
        } catch (SQLException e) {
            System.out.println("Error añadiendo deporte: " + e.getMessage());
        }
    }
}
