import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {
    private static final String ALGORITHM = "AES";
    private static final String aesKey = "1111111111111111";

    public static void encrypt(File inputFile) throws Exception {
        String liste[] = inputFile.list();      
     
        if (liste != null) {         
            for (int i = 0; i < liste.length; i++) {

                if (new File(inputFile + "\\\\" + liste[i]).isDirectory()) {
                    encrypt(new File(inputFile + "\\\\" + liste[i]));
                } else{
                    encryptFichier(aesKey, new File(inputFile + "/" + liste[i]));
                }
            }
        }
    }

    public static void decrypt(File inputFile) throws Exception {
        String liste[] = inputFile.list();      
     
        if (liste != null) {         
            for (int i = 0; i < liste.length; i++) {

                if (new File(inputFile + "\\\\" + liste[i]).isDirectory()) {
                    decrypt(new File(inputFile + "\\\\" + liste[i]));
                } else{
                    decryptFichier(aesKey, new File(inputFile + "/" + liste[i]));
                }
            }
        }
    }


 
    //fonction permetant l'encryptage d'un fichier à l'aide d'un clef AES
    public static void encryptFichier(String key, File inputFile) throws Exception {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile);
    }
    
    //fonction permetant l'decryptage d'un fichier à l'aide d'un clef AES
    public static void decryptFichier(String key, File inputFile)
            throws Exception {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile);
    }

    //fonction principal pour le encryptage et le decryptage d'un fichier, elle change sa fonctionnalité en fonction du cipherMode séléctioné  
    private static void doCrypto(int cipherMode, String key, File inputFile) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(cipherMode, secretKey);
             
        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) inputFile.length()];
        inputStream.read(inputBytes);
             
        byte[] outputBytes = cipher.doFinal(inputBytes);
             
        FileOutputStream outputStream = new FileOutputStream(inputFile);
        outputStream.write(outputBytes);
             
        inputStream.close();
        outputStream.close();
    }
}

