package dam.m6.uf2;

import java.util.List;
import java.util.Scanner;
 
public class AppMixto {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // DAO: insertar y obtener todos
        LlibreDAO dao = new LlibreJDBC();

        // Hibernate puro: buscar y actualizar
        LlibreJDBC hibernate = new LlibreJDBC();

        int opcion;

        do {
            System.out.println("\n--- MENÚ LLIBRES ---");
            System.out.println("1. ➕ Afegir llibre (DAO)");
            System.out.println("2. 📋 Mostrar tots (DAO)");
            System.out.println("3. 🔍 Buscar per autor (Hibernate)");
            System.out.println("4. ✏️ Modificar llibre per ID (Hibernate)");
            System.out.println("0. 🏁 Sortir");
            System.out.print("Opció: ");
            opcion = in.nextInt();
            in.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    // ➕ Insertar libro usando DAO
                    System.out.print("Títol: ");
                    String title = in.nextLine();
                    System.out.print("Autor: ");
                    String author = in.nextLine();
                    dao.insertar(title, author);
                    System.out.println("Llibre afegit.");
                    break;

                case 2:
                    // 📋 Obtener todos los libros usando DAO
                    List<Llibre> llibres = dao.getAll();
                    if (llibres.isEmpty()) {
                        System.out.println("No hi ha llibres.");
                    } else {
                        llibres.forEach(System.out::println);
                    }
                    break;

                case 3:
                    // 🔍 Buscar libros por autor usando Hibernate
                    System.out.print("Autor a buscar: ");
                    String searchAuthor = in.nextLine();
                    List<Llibre> llibresByAuthor = hibernate.getLlibresByAuthor(searchAuthor);
                    if (llibresByAuthor.isEmpty()) {
                        System.out.println("No s'han trobat llibres d'aquest autor.");
                    } else {
                        llibresByAuthor.forEach(System.out::println);
                    }
                    break;

                case 4:
                    // ✏️ Modificar libro usando Hibernate
                    System.out.print("ID del llibre a modificar: ");
                    int updateId = in.nextInt();
                    in.nextLine();
                    System.out.print("Nou títol (deixa en blanc per no canviar): ");
                    String newTitle = in.nextLine();
                    if (newTitle.isBlank()) newTitle = null;

                    System.out.print("Nou autor (deixa en blanc per no canviar): ");
                    String newAuthor = in.nextLine();
                    if (newAuthor.isBlank()) newAuthor = null;

                    hibernate.actualizar(updateId, newTitle, newAuthor);
                    System.out.println("Llibre actualitzat.");
                    break;

                case 0:
                    System.out.println("Sortint...");
                    break;

                default:
                    System.out.println("Opció no vàlida.");
                    break;
            }

        } while (opcion != 0);

        in.close();
        HibernateUtil.getSessionFactory().close();
    }
}
