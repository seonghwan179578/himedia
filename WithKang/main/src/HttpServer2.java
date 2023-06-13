import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HttpServer2 {


    // bad code
    public static void main(String[] args) throws Exception{


        Map<String, String> mimeMap = new HashMap<>();
        mimeMap.put("jpg","image/jpeg");
        mimeMap.put("html", "text/html");


        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Ready...........");

        for(int i =0; i < 100; i++) {

            Socket clint = serverSocket.accept();
            System.out.println(clint);

            InputStream in = clint.getInputStream();

            Scanner scanner = new Scanner(in);

            String firstLine = scanner.nextLine();

            System.out.println(firstLine);

            // /m1.jpg /
            String[] arr = firstLine.split(" ");

            String fileName = arr[1];

            String suffix = fileName.substring(fileName.lastIndexOf(".")+1);

            System.out.println(suffix);

            System.out.println("----------------------------------------------------------");
            System.out.println(Arrays.toString(arr));

            System.out.println(Arrays.toString(arr));

            OutputStream out = clint.getOutputStream();


            // 아래 4개의 out.write가 헤더
            // content-type, content-length 손보고, 실제로 보내는 데이터는 이미지 타입이어야 한다

            File file = new File("C:\\zzz" + fileName);

            long size = file.length(); // 파일 용량

            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());

            out.write(new String("Cache-Control: private\r\n").getBytes());
            // out.write(new String("Content-Length: "+size+"\r\n").getBytes());
            out.write(new String("Content-Type: "+ mimeMap.get(suffix)+"\r\n\r\n").getBytes()); // 이미지 파일에 타입이 jpeg타입

            FileInputStream fin = new FileInputStream(file);

            byte[] buffer = new byte[1024*8];

            while(true) { // 읽고 쓰기
                int count = fin.read(buffer); // count => 몇개의 새로운 파일을 찾았는지의 기능
                if(count == -1) { break;}
                out.write(buffer, 0, count);
            }




//            in.close();
//            out.close();
//            clint.close();
        } // end for

    }
}
