import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    //bad code
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://img.megabox.co.kr/SharedImg/2023/05/07/XbkZesk2KFfQbbagfMtyp8rVUWi8568M_1280.jpg");
        InputStream fin = url.openStream();


        //1단계 - 빨대 준비
        //FileInputStream fin =
        //        new FileInputStream("C:\\zzz\\test.jpg");

        FileOutputStream fos =
                new FileOutputStream("C:\\zzz\\copy.jpg");

        System.out.println(fin);

        //2 - 읽고 쓰기
        while(true){
            int data = fin.read();
            if(data == -1){
                break;
            }
            fos.write(data);
        }//end while
    }
}