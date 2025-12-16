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
        System.out.println("\nRESULTADOS:");
        for (Deportista d : lista) {
            System.out.println(
                d.getCod() + " - " + d.getNombre() +
                " (" + d.getSport().getNombre() + ")"
            );
        }
    }

    public int pedirIdDeporte() {
        System.out.print("ID deporte: ");
        return Integer.parseInt(sc.nextLine());
    }

    public String pedirNombreAtleta() {
        System.out.print("Nombre atleta: ");
        return sc.nextLine();
    }
}
