package dam.m6.uf2;

import java.util.List;
import java.util.Scanner; 

public class App 
{
    public static void main( String[] args ){
        Scanner in = new Scanner(System.in);
        LlibreDAO dao = new LlibreJDBC();

        int opcion;

        do {
            System.out.println("\n--- MENÚ LLIBRES ---");
            System.out.println("1. Afegir llibre");
            System.out.println("2. Mostrar tots");
            System.out.println("3. Buscar per ID");
            System.out.println("4. Actualitzar llibre");
            System.out.println("5. Eliminar llibre");
            System.out.println("6. Buscar per autor");
            System.out.println("0. Sortir");
            System.out.print("Opció: ");

            opcion = in.nextInt();
            in.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Títol: ");
                    String title = in.nextLine();
                    System.out.print("Autor: ");
                    String author = in.nextLine();
                    dao.insertar(title, author);
                    System.out.println("Llibre afegit.");
        
                    break;
                case 2:
                    List<Llibre> llibres = dao.getAll();
                    if (llibres.isEmpty()) {
                        System.out.println("no hi han llibres.");
                    } else {
                        llibres.forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.print("ID del llibre a buscar: ");
                    int searchId = in.nextInt();
                    in.nextLine();
                    Llibre l = dao.getAll().stream()
                            .filter(lib -> lib.getId() == searchId)
                            .findFirst()
                            .orElse(null);
                    if (l != null) {
                        System.out.println(l);
                    } else {
                        System.out.println("Llibre no trobat.");
                    }
                    break;
                case 4:
                    System.out.print("ID del llibre a actualitzar: ");
                    int updateId = in.nextInt();
                    in.nextLine();
                    System.out.print("Nou títol (deixa en blanc per no canviar):");
                    String newTitle = in.nextLine();
                    if (newTitle.isBlank()) {
                        System.out.println("El títol no s'ha canviat.");
                        newTitle = null;
                    }else{
                        System.out.println("El títol s'ha canviat.");
                    }

                    System.out.print("Nou autor (deixa en blanc per no canviar):");
                    String newAuthor = in.nextLine();
                    if (newAuthor.isBlank()) {
                        System.out.println("L'autor no s'ha canviat.");
                        newAuthor = null;
                    }else{
                        System.out.println("L'autor s'ha canviat.");
                    }
                    dao.actualizar(updateId, newTitle, newAuthor);
                    System.out.println("Llibre actualitzat.");
                    break;
                case 5:
                    System.out.print("ID del llibre a eliminar: ");
                    int deleteId = in.nextInt();
                    in.nextLine();
                    dao.eliminar(deleteId);
                    System.out.println("Llibre eliminat.");
                    break;
                case 6:
                    System.out.print("Autor a buscar: ");
                    String searchAuthor = in.nextLine();
                    List<Llibre> llibresByAuthor = dao.getLlibresByAuthor(searchAuthor);
                    if (llibresByAuthor.isEmpty()) {
                        System.out.println("No s'han trobat llibres d'aquest autor.");
                    } else {
                        llibresByAuthor.forEach(System.out::println);
                    }
                    break;
                case 0:
                    System.out.println("Sortint...");
                    break;
                default:
                    
                    break;
            }

        } while (opcion != 0);
        in.close();
        HibernateUtil.getSessionFactory().close();
    }
    
}
