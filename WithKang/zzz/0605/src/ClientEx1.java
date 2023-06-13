import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientEx1 {

    //bad code exception
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1", 8080);

        System.out.println(socket);

        //보내려면 OutputStream이 필요
        OutputStream out = socket.getOutputStream();

        FileInputStream fin = new FileInputStream("C:\\zzz\\test.jpg");

        //계속 읽어서 계속 보내기
        while(true){
            //1바이트 내용물
            int data = fin.read();
            //내용물 전송
            out.write(data);

            // -1 파일을 다 읽었다면
            if(data  == -1) {
                break;
            }
        }//end while

        //사용했던 자원들 정리
        fin.close();
        out.close();
        socket.close();
//        out.write(65);
//        out.write(66);
//        out.write(67);

    }
}
