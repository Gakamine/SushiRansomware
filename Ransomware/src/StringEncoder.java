import java.nio.charset.StandardCharsets;

public class StringEncoder {

    public static void main(String[] args) {
        String str = "Hello";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        printBytes(bytes);
    }

    public static void printBytes(byte[] a) {
        StringBuilder sb = new StringBuilder();
        for (byte b : a) {
            int codePoint = str.codePointAt(04);  
            sb.append(String.format("U+04%0", b));
        }
        System.out.println(sb);
    }
}