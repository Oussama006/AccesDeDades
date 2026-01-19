package cotxes.model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionManager {

    private static final String URI = "mongodb+srv://oussamaallali_db_user:lg7liYsxw9VQPFQc@cluster0.gf6hsvq.mongodb.net/";
    private static final String DB_NAME = "CotxesEsportius";

    public static MongoDatabase getConnection() {
        MongoClient client = MongoClients.create(URI);
        return client.getDatabase(DB_NAME);
    }
}
