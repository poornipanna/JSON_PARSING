import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Example3 {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("example3.json"));

        /*-----------------------------------------------------------------------------------------------------*/
            // with List Map Implementation

            JSONObject jsonObjects =  (JSONObject) obj;
            JSONObject responseObject = (JSONObject)jsonObjects.get("responseData");
            JSONObject feedObject =(JSONObject )responseObject.get("feed");
            List<Map<String, ?>> mapList = (List<Map<String, ?>>)feedObject.get("entries");

            for(int i=0; i< mapList.size();i++)
            {
                System.out.println("Title " +mapList.get(i).get("title").toString());
            }
         /*-------------------------------------------------------------------------------------------------------------*/
            JSONObject jsonObject =  (JSONObject) obj;
            JSONObject jsonObject1 = (JSONObject) jsonObject.get("responseData");
            JSONObject jsonObject2 = (JSONObject) jsonObject1.get("feed");
            JSONArray entriesArray = (JSONArray) jsonObject2.get("entries");
            for(int i=0; i< entriesArray.size(); i++)
            {
                JSONObject jsonObject3 = (JSONObject) entriesArray.get(i);
                System.out.println("Title from Entries- using JSON Arrays =  "+jsonObject3.get("title"));

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}