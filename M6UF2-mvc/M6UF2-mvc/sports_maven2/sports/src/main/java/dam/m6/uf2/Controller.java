package dam.m6.uf2;

import java.sql.Connection;

public class Controller {

    Connection conn;

    public static void main(String[] args) {
        System.out.println("Current directory (aquí heu de posar el XML): " + System.getProperty("user.dir"));
        Controller controller = new Controller();
        controller.init();
    }

    private void init() {

        this.conn = ConnectionManager.getConnection("database.xml");
        MainView mainView = new MainView();
        UserDAO userPgDAO = new UserDAO(conn);

        int option = mainView.mainMenu();
        // switch option
        switch (option) {
            case 1:
                mainView.showUsers(userPgDAO.getAll());
                break;

            case 2:
                User newUser = mainView.addUserForm();
                if (newUser != null) {
                    userPgDAO.add(newUser);
                } else {
                    //mainView.showError("Error al crear l'usuari");
                }

            default:
                break;
        }
        // Afegir Usuari
        // Llistar usuaris

    }
}
