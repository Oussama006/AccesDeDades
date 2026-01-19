package cotxes.controller;

import com.mongodb.client.MongoDatabase;

import cotxes.model.ConnectionManager;

public class Main {

    public static void main(String[] args) {
        MongoDatabase db = ConnectionManager.getConnection();
        System.out.println("Conexión obtenida correctamente a la base de datos: " + db.getName());
    }
}
