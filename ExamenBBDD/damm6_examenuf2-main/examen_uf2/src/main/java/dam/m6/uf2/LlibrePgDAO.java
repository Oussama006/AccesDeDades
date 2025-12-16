package dam.m6.uf2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LlibrePgDAO implements DAO {

    @Override
    public void add(Llibre llibre) {
        String sql = "INSERT INTO llibres (title,author) VALUES(?,?)";
        try (Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, llibre.getTitle());
            pst.setString(2, llibre.getAuthor());
            pst.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("Error a la hora de insertar el llibre" + e.getMessage());
        }
    }

    @Override
    public List<Llibre> getAll() {

        List<Llibre> lista = new ArrayList<>();
        String sql = "SELECT * FROM llibres";

        try (Connection conn = ConnectionManager.getConnection()) {

            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Llibre llibre = new Llibre();
                llibre.setId(rs.getInt("id"));
                llibre.setTitle(rs.getString("title"));
                llibre.setAuthor(rs.getString("author"));
                lista.add(llibre);
            }

            return lista;

        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("Error sobre el llibre" + e.getMessage());
        }
        return lista;
    }
}
