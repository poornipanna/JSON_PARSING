import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Example2 {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject= null;

        try {
            Object obj = parser.parse(new FileReader("example2.json"));

          //write code here to print all the cars for each person
            JSONArray jsonArray =  (JSONArray) obj;
            Iterator iterator = jsonArray.iterator();
            while(iterator.hasNext()) {
                jsonObject = (JSONObject) iterator.next();
                System.out.println("Name of the person:  " +jsonObject.get("name"));
                System.out.println("Cars he owns: "+jsonObject.get("cars"));
            }
/******************************************************************************************************/
            //using Map List

            List<Map<String, ?>> mapList = (List<Map<String, ?>>)obj;

            for(int i=0; i< mapList.size();i++) {
                System.out.println("Name  " + mapList.get(i).get("name").toString());
                System.out.println("Cars  " + mapList.get(i).get("cars").toString());
            }

/******************************************************************************************************/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}