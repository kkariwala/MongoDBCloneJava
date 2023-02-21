package MongoUtils;

import org.json.simple.JSONObject;

public class JSONObjectSelf {
    private static int nextJSONId = 0;
    private int _JSONId;
    private JSONObject _JSONObject;

    public JSONObjectSelf(JSONObject _JSONObject){
        this._JSONObject = _JSONObject;
        this._JSONId = nextJSONId;
        this.nextJSONId++;
    }

    public int get_JSONId(){
        return _JSONId;
    }

    public JSONObject getJSONObjectSelf(){
        return _JSONObject;
    }
}
