import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

class JsonEncodeDemo {

   public static void main(String[] args) throws URISyntaxException, IOException {
      try {
         URL url = new URL("http://sushi.joly-antoine.fr:3000");
         BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
         String string = br.readLine();
         JSONObject json = new JSONObject(string);

         String key = json.getString("encryption_key");
         String hash = json.getString("hash");

      } catch (Exception ex) {
         ex.printStackTrace();
      }

   }

}