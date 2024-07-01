package caraas.connection;

import java.util.ArrayList;
import java.util.Map;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public final class MongoDbWrapper {
    
    protected String host;
    protected int port;
    protected String database;
    protected String username;
    protected String password;
    protected MongoClient mongoClient;

    private static final MongoDbWrapper INSTANCE;

    static {
        try {
            INSTANCE = new MongoDbWrapper();
        } catch (Exception e) {
            throw new RuntimeException("Error creating Singleton instance", e);
        }
    }

    public static MongoDbWrapper getInstance() {
        return INSTANCE;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void connect() {
        // Connect to MongoDB
        String uri = "mongodb://" + getUsername() + ":" + getPassword() + "@" + getHost() + ":" + getPort() + "/" + getDatabase();
        // Construct a ServerApi instance using the ServerApi.builder() method
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)
                .build();
        // Create a new client and connect to the server
        try {
            this.mongoClient = MongoClients.create(settings);
            MongoDatabase database = this.mongoClient.getDatabase("admin");
           
            // Send a ping to confirm a successful connection
            Bson command = new BsonDocument("ping", new BsonInt64(1));
            Document commandResult = database.runCommand(command);
            System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
           
           
        } catch (MongoException me) {
            System.err.println(me);
        }


    }

    public void generateOrConnectToCollections() {
        // Generate or connect to collections in MongoDB
        try {
            MongoDatabase db2 = this.mongoClient.getDatabase("caraas");
            Map<String, Pair<String, Long>> channeld = MQTTConnectorWrapper.getInstance().getSubscribedChannels();
            MongoIterable<String> collectionNames = db2.listCollectionNames();
            // We create a collection in the database for each channel we are subscribed to (if it does not exist)
            for (String channel : channeld.keySet()) {
                // For each channel, we check if the collection exists
                if (collectionNames.into(new ArrayList<>()).contains(channel)) {
                    System.out.println("Collection " + channel + " already exists");
                    continue;
                }
                // Create a collection if it does not exist
                db2.createCollection(channel);
                System.out.println("Collection " + channel + " created successfully");
                
            }
        } catch (MongoException me) {
            System.err.println(me);
        }
    }

    public void disconnect() {
        // Disconnect from MongoDB
        try {
            this.mongoClient.close();
            System.out.println("Disconnected from MongoDB");
        } catch (MongoException me) {
            System.err.println(me);
        }
    }

    public void insert(String collection, Pair<String, Long> pair) {
        // Insert data into MongoDB
        try {
            MongoDatabase db = this.mongoClient.getDatabase("caraas");
            MongoCollection<Document> coll = db.getCollection(collection);
            Document doc = new Document("value", pair.getKey())
                    .append("timestamp", pair.getValue());
            coll.insertOne(doc);
            System.out.println("Document inserted successfully");
        } catch (MongoException me) {
            System.err.println(me);
        }
    }



}
