package dam.m6.uf2;

import java.util.List; 

public interface LlibreDAO {

    void insertar(String title, String author);
    void actualizar(int id, String newTitle, String newAuthor);
    void eliminar(int id);
    List<Llibre> getAll();
    Llibre getLlibreById(int id);
    List<Llibre> getLlibresByAuthor(String author);    
}
