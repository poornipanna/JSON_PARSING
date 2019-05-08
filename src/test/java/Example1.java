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


public class Example1 {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("example1.json"));

            JSONObject jsonObject =  (JSONObject) obj;

            //write code here to parse the json

            //print all the platforms
            JSONArray platforms = (JSONArray)jsonObject.get("platforms");
            JSONObject esrbRatingObject = (JSONObject) jsonObject.get("esrbRating");
            Iterator<Object> iterator = platforms.iterator();
            while(iterator.hasNext())
            {
                System.out.println("platform=" +iterator.next());
            }


            System.out.println("esrbRating, Code is =" +esrbRatingObject.get("code"));
/***************************************************************************************/
        //Using Map List
        List<Map<String, ?>>platformList = (List<Map<String, ?>>)jsonObject.get("platforms");

        for(int i=0; i< platformList.size();i++)
        {
            System.out.print("Id  " +platformList.get(i).get("id").toString());
            System.out.print("Platform  " +platformList.get(i).get("name").toString());
            System.out.println("");
        }

        Map<String, ?> esrbRating = (Map<String, ?>)jsonObject.get("esrbRating");
        System.out.println("Id  " +esrbRating.get("id").toString());
        System.out.println("Code  " +esrbRating.get("code").toString());
        System.out.println("Name  " +esrbRating.get("name").toString());
        System.out.println("");


/**************************************************************************************/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}