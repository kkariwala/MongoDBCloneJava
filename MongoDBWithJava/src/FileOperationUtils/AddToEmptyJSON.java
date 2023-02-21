package FileOperationUtils;

import MongoUtils.MongoDB;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import MongoUtils.JSONObjectSelf;

public class AddToEmptyJSON {
    /**
     * This method adds an Object to an empty JSON file and handles exceptions
     *
     * @param path Absolute path of the JSON file
     * @param key key for the key value pair
     * @param j the object that forms the value of the key-value pair
     * @return void
     * @see JSONObjectSelf
     */
    public static void addToEmptyJSON(String path, String key, JSONObjectSelf j){
        try{
            JSONObject obj2 = new JSONObject();
            JSONObject obj1=new JSONObject();
            obj1.put(key,j.getJSONObjectSelf());
            obj2.put(j.get_JSONId(),obj1);
            FileWriter fw = new FileWriter(path);
            fw.write(obj2.toJSONString());
            fw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
