package MongoUtils;

import FileOperationUtils.AddToEmptyJSON;
import FileOperationUtils.AppendToJSON;
import FileOperationUtils.DeleteFromJSON;

import java.io.File;
import java.util.HashMap;

public class CollectionClass {
    private String name;
    private String collectionPath;
    private static int idNumber;

    private HashMap<String,JSONObjectSelf> objects;

    public CollectionClass(String name, String collectionPath){
        this.objects = new HashMap<>();
        this.idNumber = 0;
        this.name = name;
        this.collectionPath = collectionPath;
    }

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

    public void deleteObjectFromCollection(String key){
        //get the objectID
        DeleteFromJSON.deleteObjectFromJSON(collectionPath,String.valueOf(objects.get(key).get_JSONId()));
        objects.remove(key);
    }
}
