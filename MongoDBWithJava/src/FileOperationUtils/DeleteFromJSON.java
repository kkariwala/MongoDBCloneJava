package FileOperationUtils;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import MongoUtils.JSONObjectSelf;
import MongoUtils.MongoDB;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DeleteFromJSON {
    /**
     * This method deletes an Object from a JSON file and handles exceptions
     *
     * @param filePath Absolute path of the JSON file
     * @param objectId Identification for the oject to be deleted
     * @return void
     * @see MongoDB
     * @see JSONObjectSelf
     */
    public static void deleteObjectFromJSON(String filePath, String objectId){
        try (FileReader fileReader = new FileReader(filePath)) {
            JSONParser jsonParser = new JSONParser();
            // parse the json file as json object
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            jsonObject.remove(objectId);
            // write data to output file
            FileWriter fw = new FileWriter(filePath);
            fw.write(jsonObject.toJSONString());
            fw.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
