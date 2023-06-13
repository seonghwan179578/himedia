import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientEx1 {

    // bad code
    public static void main(String[] args) throws  Exception{

        Socket socket = new Socket("192.168.0.46", 8080); // server ip주소(범수님 ip)

        System.out.println(socket);

        // 보내려면 OutputStream이 필요
        OutputStream out = socket.getOutputStream(); // 이걸 이용해서 데이터를 보낼 수 있음

        // 파일 데이터 보내기
        FileInputStream fin = new FileInputStream("C:\\zzz\\test.jpg");

        // 계속 읽어서 계속 보내기. 파일 용량을 모르니까 다 보낼 떄 까지 보내는 것
        while(true) { // 한 모금 빨고 한 모금 뱉는 과정. 속도가 느리다는 단점
            // 1바이트 내용물
            int data = fin.read();
            // 내용물 전송
            out.write(data);

            // -1 => 파일을 다 읽었으면(한 모금씩 빨면서 다 빨아먹었으면) 중지
            if (data == -1) {
                break;
            }
        }//end while
        // 사용했던 자원들 정리 // 보낸 파일 용량이 서버 역할 pc에서 1바이트면 클라이언트에 문제가 있는 것이니 확인 필요
        fin.close(); // fin 종료
        out.close(); // out 종료
        socket.close(); // socket 종료

        // 데이터 3바이트(숫자)를 서버로 보내기
//        out.write(65);
//        out.write(66);
//        out.write(67);

    }
}
