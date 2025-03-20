package tf.isd.controller;

import com.mongodb.client.*;
import org.bson.Document;

public class MongoDBTest {
    public static void main(String[] args) {
        String uri = "mongodb://isd_admin:<password>@ac-wjttubv-shard-00-00.ll43kyu.mongodb.net:27017,ac-wjttubv-shard-00-01.ll43kyu.mongodb.net:27017,ac-wjttubv-shard-00-02.ll43kyu.mongodb.net:27017/?replicaSet=atlas-12yf1u-shard-0&ssl=true&authSource=admin&retryWrites=true&w=majority&appName=ClusterISD2024";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ISD_DB");
            MongoCollection<Document> collection = database.getCollection("Test_Collection");

            // Insert a Document
            Document doc = new Document("name", "Jamie Woo")
                    .append("gender", "Male")
                    .append("age", "22")
                    .append("job", "boss");
            collection.insertOne(doc);
            System.out.println("Inserted user: " + doc.toJson());

            // Retrieve Documents
            FindIterable<Document> users = collection.find();
            for (Document user : users) {
                System.out.println("User: " + user.toJson());
            }
        }
    }
}