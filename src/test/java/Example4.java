import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Example4 {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        JSONObject jsonPhoneObject=null;

        try {
            Object obj = parser.parse(new FileReader("example4.json"));

          //write code here to print all the type of phone no and the corresponding no
            JSONObject jsonObject =  (JSONObject) obj;
            JSONArray phoneNumber = (JSONArray)jsonObject.get("phoneNumber");
            Iterator<Object> iterator = phoneNumber.iterator();
            while(iterator.hasNext())
            {
                jsonPhoneObject = (JSONObject)iterator.next();
                System.out.println("Type of phone number =  "+jsonPhoneObject.get("type"));
                System.out.println("Phone Number is =  "+jsonPhoneObject.get("number"));
            }
/**********************************************************************************************************/
//With List Map Implementation

            JSONObject jsonObjects =  (JSONObject) obj;
            List<Map<String, ?>> mapList = (List<Map<String, ?>>)jsonObjects.get("phoneNumber");

            for(int i=0; i< mapList.size();i++) {
                System.out.println("type  " + mapList.get(i).get("type").toString());
                System.out.println("number  " + mapList.get(i).get("number").toString());
            }

/*----------------------------------------------------------------------------------------------------------*/


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}