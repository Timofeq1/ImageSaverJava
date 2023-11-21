import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Week_12_ExceptionsGit {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input file url address...");
            String url = sc.nextLine();
            System.out.println("Input path on your machine...");
            String dest = sc.nextLine();
            saveImage(dest, url);
        } catch (Exception e) {
            System.out.println("eee");;
        }
    }
    public static void saveImage(String destPath,String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        String fileName = url.getFile();
        String destName = destPath + fileName.substring(fileName.lastIndexOf("/"));
        System.out.println(destName);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destName);
        byte[] b = new byte[2000];
        int length;
        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }
        is.close();
        os.close();
    }
}
