package com.iqmsoft.payara.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Startup
@Singleton
public class DBConn {

    @PostConstruct
    private void init() {
        MongoClientURI uri = new MongoClientURI(
                "mongodb://localhost:27017");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test1");
        final String collectionName = "myfirstcollection";
        database.createCollection(collectionName);

        Document docBeforeUpdate = new Document("key1", "value1");
        database.getCollection(collectionName).insertOne(docBeforeUpdate);
        final FindIterable<Document> documents = database.getCollection(collectionName).find();
        for (Document document : documents) {
            System.out.println("document = " + document.toJson());
        }
    }

}
