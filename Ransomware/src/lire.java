import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
   public static void main(String args[]) {
      JSONParser jsonP = new JSONParser();
      try {
         JSONObject jsonO = (JSONObject)jsonP.parse(new FileReader("C:/person.json"));
     
         String cle = (String) jsonO.get("cle");
         String sign = (String) jsonO.get("sign");


         System.out.println("cle :"+ cle);
         System.out.println("sign: "+ sign);

      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      }
   }
}