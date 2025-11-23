package dam.m6.uf2;

import java.util.List;
import java.util.Scanner;

public class MainView {

    /**
     * @return
     */
    public int mainMenu() {
        // TODO Auto-generated method stub
        System.out.println("1. Llistat usuaris\n2 Afegir Usuari\n....\n...\n0 Sortir --> conn.close()");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        //sc.close();
        return option;
        //throw new UnsupportedOperationException("Unimplemented method 'mainMenu'");
    }

    public void showUsers(List<User> list) {
        // Llistat d'usuaris
        System.out.println("MOSTRAR LLISTAT USUARIS....");
        for (User user : list) {
            System.out.println(user.name + "\t" + user.password + "\tetc");
        }
    }

    public User addUserForm() {
        // Formulari usuari,
        System.out.println("FORMULARI USUARI....nom, pass, etc");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = "1234";

        return new User(username, password);
    }

}
