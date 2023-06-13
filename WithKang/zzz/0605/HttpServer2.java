import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpServer2 {

    //bad code
    public static void main(String[] args)throws Exception {

        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Ready..........");

        for (int i = 0; i < 100; i++) {

            Socket client = serverSocket.accept();
            System.out.println(client);

            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            File file = new File("C:\\zzz\\test.jpg");

            long size = file.length();

            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());

            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length: "+size+"\r\n").getBytes());
            out.write(new String("Content-Type: image/jpeg\r\n\r\n").getBytes());

            FileInputStream fin = new FileInputStream(file);

            byte[] buffer = new byte[1024*8];

            while(true){
                int count = fin.read(buffer);
                if(count == -1){ break;}
                out.write(buffer,0,count);
            }



            in.close();
            out.close();
            client.close();
        }//end for



    }
}
