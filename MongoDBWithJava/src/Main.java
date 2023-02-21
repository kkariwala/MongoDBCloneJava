import MongoUtils.JSONObjectSelf;
import MongoUtils.MongoDB;
import org.json.simple.JSONObject;

public class Main {
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