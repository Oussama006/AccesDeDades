package cat.dam.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;
import org.bson.types.ObjectId;

import cat.dam.model.Cotxe;

public class View {

    private static final Scanner sc = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static int menu() {
        System.out.println("""
        ===== GESTIÓ DE COTXES =====
        1. Afegir cotxe
        2. Eliminar cotxe
        3. Modificar cotxe
        4. Llistar tots
        5. Llistar per dates
        6. Cercar per model
        0. Sortir
        ===========================
        """);
        System.out.print("Opció: ");

        int op = sc.nextInt();
        sc.nextLine(); 
        return op;
    }

    public static Cotxe askCotxe() {

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Model: ");
        String model = sc.nextLine();

        System.out.print("Potència CV: ");
        int cv = sc.nextInt();

        System.out.print("Preu: ");
        double preu = sc.nextDouble();

        System.out.print("Disponible (true/false): ");
        boolean disp = sc.nextBoolean();

        sc.nextLine(); 
        System.out.print("Descripció: ");
        String desc = sc.nextLine();

        return new Cotxe(marca, model, cv, preu, new Date(), disp, desc);
    }

    public static void mostrarCotxes(List<Document> docs) {
        int i = 1;

        for (Document d : docs) {
            System.out.println("[" + i++ + "] "
                    + d.getString("marca") + " "
                    + d.getString("model")
                    + " (" + d.getInteger("potenciaCV") + " CV)");
        }

        if (docs.isEmpty()) {
            System.out.println("No hi ha cotxes.");
        }
    }

    public static ObjectId seleccionarCotxe(List<Document> docs) {

        if (docs.isEmpty()) {
            System.out.println("No hi ha cotxes per seleccionar.");
            return null;
        }

        mostrarCotxes(docs);

        System.out.print("Selecciona número: ");
        int pos = sc.nextInt() - 1;
        sc.nextLine(); 

        if (pos < 0 || pos >= docs.size()) {
            System.out.println("Selecció no vàlida.");
            return null;
        }

        String idStr = docs.get(pos).getString("_id");

        return new ObjectId(idStr);
    }

    public static String askModel() {
        System.out.print("Text a cercar: ");
        return sc.nextLine();
    }

    public static Date askDate(String msg) {
        try {
            System.out.print(msg + " (yyyy-MM-dd): ");
            return sdf.parse(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Format incorrecte. S'utilitza la data actual.");
            return new Date();
        }
    }
}