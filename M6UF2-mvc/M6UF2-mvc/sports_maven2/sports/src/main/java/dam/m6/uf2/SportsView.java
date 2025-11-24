package dam.m6.uf2;

import java.util.List;
import java.util.Scanner;
import dam.m6.uf2.model.Deportista;
import dam.m6.uf2.model.Sport;

public class SportsView {

    Scanner sc = new Scanner(System.in);

    public int menu() {
        System.out.println("\n===== MENÚ =====");
        System.out.println("1. Listar deportes");
        System.out.println("2. Listar deportistas por deporte");
        System.out.println("3. Añadir deporte");
        System.out.println("4. Añadir deportista");
        System.out.println("5. Buscar atleta por nombre");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        return Integer.parseInt(sc.nextLine());
    }

    public Sport esportForm() {
        System.out.print("Nombre deporte: ");
        return new Sport(sc.nextLine());
    }

    public Deportista atletaForm(List<Sport> deportes) {
        System.out.println("\nDeportes disponibles:");
        for (Sport s : deportes) {
            System.out.println(s.getCod() + ". " + s.getNombre());
        }

        System.out.print("ID deporte: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Nombre atleta: ");
        String nombre = sc.nextLine();

        return new Deportista(nombre, id);
    }

    public void mostrarEsports(List<Sport> lista) {
        System.out.println("\nDEPORTES:");
        for (Sport s : lista) {
            System.out.println(s.getCod() + ". " + s.getNombre());
        }
    }

    public void mostrarAtletas(List<Deportista> lista) {
        System.out.println("\nATLETAS:");
        for (Deportista d : lista) {
            System.out.println(d.getCod() + " - " + d.getNombre());
        }
    }

    public void mostrarBusqueda(List<Deportista> lista) {
        System.out.println("\nRESULTADOS DE LA BÚSQUEDA:");
        for (Deportista d : lista) {
            System.out.println(d.getCod() + " - " + d.getNombre() + " (" + d.getDeporte() + ")");
        }
    }

    public int pedirIdDeporte() {
        System.out.print("Introduce el ID del deporte: ");
        return Integer.parseInt(sc.nextLine());
    }

    public String pedirNombreAtleta() {
        System.out.print("Introduce parte del nombre del atleta: ");
        return sc.nextLine();
    }
}
