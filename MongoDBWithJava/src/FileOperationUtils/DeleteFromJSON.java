package FileOperationUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DeleteFromJSON {
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
