package MongoUtils;

import org.json.simple.JSONObject;

public class JSONObjectSelf {
    private static int nextJSONId = 0;
    private int _JSONId;
    private JSONObject _JSONObject;

    /**
     * Class constructor specifying the JSONObject to be stored
     */
    public JSONObjectSelf(JSONObject _JSONObject){
        this._JSONObject = _JSONObject;
        this._JSONId = nextJSONId;
        this.nextJSONId++;
    }

    /**
     * This method gets the JSONId for a specific JSON Object
     *
     * @return the _JSONId
     */
    public int get_JSONId(){
        return _JSONId;
    }


    /**
     * This method gets the JSONObect for a specific JSON Object
     *
     * @return the JSONObject
     */
    public JSONObject getJSONObjectSelf(){
        return _JSONObject;
    }
}
