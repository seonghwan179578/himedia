import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpServer1 {


    // bad code
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Ready...........");

        for(int i =0; i < 100; i++) {

            Socket clint = serverSocket.accept();
            System.out.println(clint);

            InputStream in = clint.getInputStream();
            OutputStream out = clint.getOutputStream();

            String msg = "<h1>Hello World</h1>";

            // 아래 4개의 out.write가 헤더
            // content-type, content-length 손보고, 실제로 넘기는 데이터는 이미지 타입이어야 한다
            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());

            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length: "+msg.getBytes("UTF-8").length+"\r\n").getBytes());
            out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());

            out.write(msg.getBytes(StandardCharsets.UTF_8));



            in.close();
            out.close();
            clint.close();
        } // end for

    }
}
