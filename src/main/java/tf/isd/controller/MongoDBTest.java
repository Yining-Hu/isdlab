package tf.isd.controller;

import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.MongoException;
import tf.isd.model.dao.MongoDBManager;
import java.util.Scanner;

public class MongoDBTest {
    private static Scanner in = new Scanner(System.in);

    private static MongoDBManager db = new MongoDBManager();

    private static void testAdd() {
        // add a document
        Document doc = new Document("name", "Jamie Woo")
                .append("gender", "Male")
                .append("age", "22")
                .append("job", "boss");
        db.collection.insertOne(doc);
        System.out.println("Inserted user: " + doc.toJson());
    }

    private static void testFindAll() {
        FindIterable<Document> users = db.collection.find();
        for (Document user : users) {
            System.out.println("User: " + user.toJson());
        }
    }

    private static char readChoice() {
        System.out.print("Please select (A)-add a document, (R)-read all documents, or * to exit: ");
        return in.nextLine().charAt(0);
    }

    private static void runQueries() {
        char c;

        while ((c=readChoice()) != '*') {
            switch (c) {
                case 'A':
                    testAdd();
                    break;
                case 'R':
                    testFindAll();
                    break;
                default:
                    System.out.println("Please select (A)-add a document, (R)-read all documents, or * to exit: ");
            }
        }
        in.close();
    }
    public static void main(String[] args) throws MongoException{
        try{
            MongoDBTest.runQueries();
        } finally {
            db.close();
        }
    }    
}