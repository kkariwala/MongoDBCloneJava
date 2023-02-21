package MongoUtils;

import FileOperationUtils.*;
import org.json.simple.JSONObject;

import java.util.HashMap;


public class MongoDB {
    private String databaseName;
    HashMap<String,CollectionClass> collections;
    private String pathOfDatabase;
    public MongoDB(String databaseName){
        this.databaseName = databaseName;
        this.collections = new HashMap<>();
        //Creates a folder in the Databases package with the name as provided by the user
        String pathName = "/Users/kkariwala/Desktop/Aspire InfoLabs/OOPS Concepts/Java_Assignment_OOPS/MongoDBWithJava/Databases/";
        this.pathOfDatabase = pathName+databaseName + "/";
        System.out.println(pathOfDatabase);
        MakeFolder.makeFolder(pathName,databaseName);
    }
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

    public void addToCollection(String collectionName, String key,JSONObjectSelf j){
        if(!collections.containsKey(collectionName)){
            System.out.println("This collection does not exist, cannot add to it!");
            return;
        }
        //collection exists, in that case, add to the JSON file.
        collections.get(collectionName).addObjectToCollection(key,j);
    }

    public void deleteObjectFromCollection(String collectionName, String key){
        if(!collections.containsKey(collectionName)){
            System.out.println("This collection does not exist, cannot delete from it!");
            return;
        }
        //collection exists, in that case, delete from the JSON file.
        collections.get(collectionName).deleteObjectFromCollection(key);
    }

    public void printAllCollections(){
        System.out.println("All Available Collections in the database " + databaseName + " are :-");
        int i = 1;
        for (String name : collections.keySet())
        {
            System.out.println(i + ": " + name);
            i++;
        }
    }

    public static void main(String[] args) {
        MongoDB m1 = new MongoDB("kunal");
        m1.createCollection("persons");
//        m1.deleteCollection("persons");
        JSONObject j1 = new JSONObject();
        j1.put("salary",  Double.valueOf(23000.45));
        j1.put("pronouns","he/him");
        j1.put("nationality","Indian");
        JSONObjectSelf js1 = new JSONObjectSelf(j1);
        JSONObject j2 = new JSONObject();
        j2.put("salary",  Double.valueOf(23002.45));
        j2.put("pronouns","they/them");
        j2.put("nationality","Indian");
        JSONObjectSelf js2 = new JSONObjectSelf(j2);
        JSONObject j3 = new JSONObject();
        j3.put("salary",  Double.valueOf(23004343.45));
        j3.put("pronouns","she/her");
        j3.put("nationality","Indian");
        JSONObjectSelf js3 = new JSONObjectSelf(j3);
        m1.addToCollection("persons","kunal",js1);
        m1.addToCollection("persons","hardik",js2);
        m1.addToCollection("persons","janvi",js3);
        m1.createCollection("departments");
        m1.deleteObjectFromCollection("persons","hardik");
        m1.printAllCollections();
    }
}
