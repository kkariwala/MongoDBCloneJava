package FileOperationUtils;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import MongoUtils.JSONObjectSelf;

public class AddToEmptyJSON {
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
