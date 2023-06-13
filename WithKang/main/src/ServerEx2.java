import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx2 {
    
    // bad code
    public static void main(String[] args) throws Exception{
        
        // 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket( 8080);

        while (true) {
            Socket clint = serverSocket.accept();
            System.out.println(clint);
            // 파일 데이터 전송
            FileInputStream fin = new FileInputStream(("C:\\zzz\\test.jpg"));

            byte[] buffer = new byte[1024*8]; // 8kb(킬로바이트)

            long start = System.currentTimeMillis();


            // 데이터 전송용 out
            OutputStream out = clint.getOutputStream();

            while (true) {
                int count = fin.read(buffer);
                if(count == -1) {break;}
                out.write(buffer, 0, count);
//                int data = fin.read();
//                if(data == -1) {break;}
//                out.write(data);
            }

            out.close();
            fin.close();
            clint.close();
        }

        // accept() 클라이언트 접속
        
        // 읽기 쓰기

        //close()
        
    }
}
