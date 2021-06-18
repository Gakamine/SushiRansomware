import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {

        File fichierAEncrypter = new File("/home/mekju/Documents/fichierToEncrypt.txt");
        File dossierAEncrypter = new File("/home/mekju/Documents/dossierAEncrypter/");

        crypto.encryptDossier(dossierAEncrypter);
        //crypto.decryptDossier(dossierAEncrypter);

        //crypto.encryptFichier("akchdjrieuhfncmd", fichierAEncrypter);
        //crypto.decryptFichier("akchdjrieuhfncmd", fichierAEncrypter);
    }
}
