import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
// 서버가 보낸 걸 받는 역할

public class ClientEx2 {

    // bad code
    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("192.168.0.48",8080);

        InputStream in = socket.getInputStream(); // 서버가 보낸 파일을 받은 클라이언트가 파일 저장

        FileOutputStream fos = new FileOutputStream("C:\\zzz\\server.jpg");

        while(true) {
            int data = in.read();
            if(data == -1) {break;}
            fos.write(data);
        } // end while

        in.close();
        fos.close();
        socket.close();


    }


}
