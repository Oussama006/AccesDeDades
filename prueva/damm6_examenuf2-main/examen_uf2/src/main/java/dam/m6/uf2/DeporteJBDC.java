package dam.m6.uf2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeporteJBDC implements DeporteDAO {

    public static final String INSERT_DEPORTE = "INSERT INTO deportes (nombre) VALUES (?);";

    public void insert(Deporte deporte) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(INSERT_DEPORTE);
            ps.setString(1, deporte.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
