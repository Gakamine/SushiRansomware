import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
   public static void main(String args[]) {
      JSONParser jsonP = new JSONParser();
      try {
         JSONObject jsonO = (JSONObject)jsonP.parse(new FileReader("C:/sushi.json"));
     
         String cle = (String) jsonO.get("clé");
         String signature = (String) jsonO.get("signature");

         System.out.println("cle :"+ cle);
         System.out.println("signature: "+ signature);
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      }
   }
}

