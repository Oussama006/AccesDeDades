package cat.dam.model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class ConnectionManager {

    private static final String URI = "mongodb+srv://oussamaallali_db_user:QvZAvOx3muQ6VBjn@cluster0.gf6hsvq.mongodb.net/CotxesEsportius?retryWrites=true&w=majority";

    public static MongoClient getConnection() {
        return MongoClients.create(URI);
    }
}
