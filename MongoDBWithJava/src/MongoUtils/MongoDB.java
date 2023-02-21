package MongoUtils;

import FileOperationUtils.*;
import org.json.simple.JSONObject;

import java.util.HashMap;


public class MongoDB {
    private String databaseName; //Stores the name of the database
    HashMap<String,CollectionClass> collections; //Stores all collections available in the current database
    private String pathOfDatabase; //stores the path of the database

    /**
     * Class constructor specifying name of the database.
     */
    public MongoDB(String databaseName){
        this.databaseName = databaseName;
        this.collections = new HashMap<>();
        //Creates a folder in the Databases package with the name as provided by the user
        String pathName = "/Users/kkariwala/Desktop/Aspire InfoLabs/MongoDBCloneJava/MongoDBWithJava/Databases/";
        this.pathOfDatabase = pathName+databaseName + "/";
        System.out.println(pathOfDatabase);
        MakeFolder.makeFolder(pathName,databaseName);
    }

    /**
     * This method creates a collection for a specific MongoDB object and stores it in th HashMap
     * If the collection exists, it will throw an error and not create a new Collection
     * else if will create
     *
     * @param  collectionName name of the collection to be created
     * @return void
     * @see MongoDB
     * @see CollectionClass
     */
    public void createCollection(String collectionName){
        //create a collection in that database directory of this name, i.e. create a JSON File.

        //first check if the collection already exists
        if(collections.containsKey(collectionName)){
            System.out.println("This collection already exists, kindly use that!");
            return;
        }
        //collection does not exist, in that case, create a new JSON file with that name
        CollectionClass collection = new CollectionClass(collectionName,pathOfDatabase+collectionName+".json");
        collections.put(collectionName,collection);
        CreateFile.createFile(pathOfDatabase + collectionName + ".json");
    }

    /**
     * This method deletes a collection for a specific MongoDB object and also deletes it from the HashMap
     * If the collection does not exist, it will throw an error and will not try to delete that collection
     * else it will delete
     *
     * @param  collectionName name of the collection to be deleted
     * @return void
     * @see MongoDB
     * @see CollectionClass
     */
    public void deleteCollection(String collectionName){
        //create a collection in that database directory of this name, i.e. create a JSON File.

        //first check if the collection exists or not, if it doesn't, throw an error
        if(!collections.containsKey(collectionName)){
            System.out.println("This collection does not exist, cannot delete!");
            return;
        }
        //collection exists, in that case, delete the json file with that name
        collections.remove(collectionName);
        DeleteFile.deleteFile(pathOfDatabase,collectionName + ".json");
    }


    /**
     * This method adds an JSONObject to a collection for a specific MongoDB object
     * If the collection does not exist, it will throw an error and will not try to add to that collection
     * else it will add
     *
     * @param  collectionName name of the collection to be added to
     * @param key String key of the key-value pair where the value is the object
     * @param j JSONObjectSelf value for the key-value pair
     * @return void
     * @see MongoDB
     * @see CollectionClass
     * @see JSONObjectSelf
     */
    public void addToCollection(String collectionName, String key,JSONObjectSelf j){
        if(!collections.containsKey(collectionName)){
            System.out.println("This collection does not exist, cannot add to it!");
            return;
        }
        //collection exists, in that case, add to the JSON file.
        collections.get(collectionName).addObjectToCollection(key,j);
    }


    /**
     * This method deletes an JSONObject from a collection for a specific MongoDB object
     * If the collection does not exist, it will throw an error and will not try to delete from that collection
     * else it will delete
     *
     * @param  collectionName name of the collection to be deleted from
     * @param key String key of the key-value pair where the value is the object
     * @return void
     * @see MongoDB
     * @see CollectionClass
     * @see JSONObjectSelf
     */
    public void deleteObjectFromCollection(String collectionName, String key){
        if(!collections.containsKey(collectionName)){
            System.out.println("This collection does not exist, cannot delete from it!");
            return;
        }
        //collection exists, in that case, delete from the JSON file.
        collections.get(collectionName).deleteObjectFromCollection(key);
    }

    /**
     * This method prints all the names of collections created for a specific MongoDB object
     *
     * @return void
     * @see MongoDB
     * @see CollectionClass
     * @see JSONObjectSelf
     */
    public void printAllCollections(){
        System.out.println("All Available Collections in the database " + databaseName + " are :-");
        int i = 1;
        for (String name : collections.keySet())
        {
            System.out.println(i + ": " + name);
            i++;
        }
    }
}
