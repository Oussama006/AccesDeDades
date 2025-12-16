package dam.m6.uf2;

import java.util.List;

public interface DeportistaDAO {

    void insert(Deportista Deportista);

    List<Deportista> buscarDeportista(String name);
    
}
