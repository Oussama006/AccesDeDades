package dam.m6.uf2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dam.m6.uf2.model.Deportista;

public class DeportistaDAO implements DAO<Deportista> {

    private Connection conn;

    public DeportistaDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void add(Deportista d) {
        String sql = "INSERT INTO deportistas(nombre, cod_deporte) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getNombre());
            ps.setInt(2, d.getCodDeporte());
            ps.executeUpdate();
            System.out.println("Deportista añadido.");
        } catch (SQLException e) {
            System.out.println("Error añadiendo deportista: " + e.getMessage());
        }
    }

    @Override
    public List<Deportista> getAll() {
        List<Deportista> lista = new ArrayList<>();

        String sql = "SELECT * FROM deportistas";

        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Deportista(
                        rs.getString("nombre"),
                        rs.getInt("cod")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo deportistas.");
        }

        return lista;
    }

    public List<Deportista> listarPorDeporte(int idSport) {
        List<Deportista> lista = new ArrayList<>();

        String sql = "SELECT * FROM llistaDeportistasDeSports(?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idSport);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Deportista(
                        rs.getString("nombre"),
                        rs.getInt("cod")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error función deportistas: " + e.getMessage());
        }
        return lista;
    }

    public List<Deportista> buscarPorNombre(String nombre) {
        List<Deportista> lista = new ArrayList<>();

        String sql = "SELECT d.cod, d.nombre, s.nombre AS deporte "
                + "FROM deportistas d "
                + "JOIN deportes s ON d.cod_deporte = s.cod "
                + "WHERE d.nombre ILIKE ? "
                + "ORDER BY d.cod";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nombre + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Deportista(
                            rs.getInt("cod"),
                            rs.getString("nombre"),
                            rs.getString("deporte")
                    ));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error buscant atleta: " + e.getMessage());
        }

        return lista;
    }
}
