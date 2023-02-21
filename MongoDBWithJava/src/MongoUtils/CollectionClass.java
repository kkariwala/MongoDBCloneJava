package MongoUtils;

import FileOperationUtils.AddToEmptyJSON;
import FileOperationUtils.AppendToJSON;
import FileOperationUtils.DeleteFromJSON;

import java.io.File;
import java.util.HashMap;

public class CollectionClass {
    private String name; //Name of the collection
    private String collectionPath; //Absolute path of the collection
    private HashMap<String,JSONObjectSelf> objects; //What all objects this collection has

    /**
     * Class constructor specifying the name of the Collection and the Absolute path of the collection
     */
    public CollectionClass(String name, String collectionPath){
        this.objects = new HashMap<>();
        this.name = name;
        this.collectionPath = collectionPath;
    }

    /**
     * This method adds an Object to a collection for a specific MongoDB object and stores it in the HashMap
     *
     * @param key key with which the object will be identified
     * @param j the object that will form the value of the key-value pair
     * @return void
     * @see MongoDB
     * @see JSONObjectSelf
     */
    public void addObjectToCollection(String key,JSONObjectSelf j){
        objects.put(key,j);
        try{
            File file = new File(collectionPath);
            if(file.length() == 0){
                //file is empty, just simply write
                AddToEmptyJSON.addToEmptyJSON(collectionPath,key,j);
            }
            else{
                //file is not empty, we will have to append it.
                AppendToJSON.appendToJSON(collectionPath,key,j);
            }
        }
        catch (SecurityException e){
            e.printStackTrace();
        }
    }

    /**
     * This method deletes an Object from a collection for a specific MongoDB object and deletes it from the HashMap
     *
     * @param key key with which the object will be identified
     * @return void
     * @see MongoDB
     * @see JSONObjectSelf
     */
    public void deleteObjectFromCollection(String key){
        //get the objectID
        DeleteFromJSON.deleteObjectFromJSON(collectionPath,String.valueOf(objects.get(key).get_JSONId()));
        objects.remove(key);
    }
}
