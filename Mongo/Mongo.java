package Mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Mongo {
    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ma_base");

            
            database.runCommand(new Document("ping", 1));
            System.out.println("Connexion MongoDB réussie !");

            MongoCollection<Document> collection = database.getCollection("Clients");
            System.out.println("Nombre de documents : " + collection.countDocuments());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}