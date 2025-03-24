package tf.isd.model.dao;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBManager {
    private MongoClient mongoClient;
    private MongoDatabase database;
    public MongoCollection<Document> collection;
    private String uri = "<connection_string>";
    private String databaseName = "<database_name>";
    private String collectionName = "<collection_name>";

    // connect to your MongoDB
    public MongoDBManager() {
        mongoClient = MongoClients.create(uri);
        database = mongoClient.getDatabase(databaseName);
        collection = database.getCollection(collectionName);
    }

    // add a document
    public void addDocument(String databaseName, String collectionName, Document doc) {
        collection.insertOne(doc);
        System.out.println("Inserted user: " + doc.toJson());
    }

    // retrieve all documents
    public void findAllDocument(String databaseName, String collectionName, Document doc) {
        FindIterable<Document> users = collection.find();
        for (Document user : users) {
            System.out.println("User: " + user.toJson());
        }
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("MongoDB connection closed.");
        }
    }
}
