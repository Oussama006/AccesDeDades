package dam.m6.uf2;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        LlibrePgDAO dao = new LlibrePgDAO();
        Llibre hiber = new Llibre();

        int opcio;

        do {

            System.out.println("------------Menú------------");
            System.out.println("1. Llistar llibres amb JDBC");
            System.out.println("2. Afegir Llibre amb JDBC");
            System.out.println("3. Afegir Llibre Hibernate");
            System.out.println("0. Sortir");

            opcio = in.nextInt();
            in.nextLine();

            switch (opcio) {
                case 1:
                    List<Llibre> llibres = dao.getAll();
                    if (llibres.isEmpty()) {
                        System.out.println("no hi han llibres.");
                    } else {
                        llibres.forEach(System.out::println);
                    }
                    break;
                case 2:
                    System.out.println("Introdueix el titol: ");
                    String title = in.nextLine();
                    System.out.println("Introdueix el autor: ");
                    String author = in.nextLine();
                    dao.add(new Llibre(title, author));
                    break;
                case 3:
                    System.out.println("Introdueix el titol: ");
                    String titleHiber = in.nextLine();
                    System.out.println("Introdueix el autor: ");
                    String authorHiber = in.nextLine();
                    hiber.addHibernate(new Llibre(titleHiber, authorHiber));
                    break;

                case 0:
                    System.out.println("Sortin del programa...");
                    break;
                default:
                    break;
            }

        } while (opcio != 0);

    }

}
