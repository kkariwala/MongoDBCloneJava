package FileOperationUtils;

import MongoUtils.JSONObjectSelf;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AppendToJSON {
    public static void appendToJSON(String path, String key, JSONObjectSelf j){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject =  (JSONObject) obj;
            JSONObject obj1=new JSONObject();
            obj1.put(key,j.getJSONObjectSelf());
            jsonObject.put(j.get_JSONId(),obj1);
            FileWriter fw = new FileWriter(path);
            fw.write(jsonObject.toJSONString());
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
