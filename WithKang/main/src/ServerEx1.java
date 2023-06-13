// public class ServerEx1 {
//
////     bad code
////    public static void main(String[] args) throws Exception {
////         서버 담당
////
////         서버 소켓 준비 포트 필요 // 리스너 : 손님 방문을 기다리는 사람 역할
////         ServerSocket serverSocket = new ServerSocket(8080); // 서버 준비 완료
////
////         연결 기다리다가 확인
////         for(int i = 0; i < 100; i++) {
////         Socket clientSocket = serverSocket.accept();
////         System.out.println(clintSocket);
////
////         읽기 위한 InputStream 필요
////         InputStream in = clintSocket.getInputStream();
////         FileOutputStream fos = new FileOutputStream("C:\\zzz\client"+i+".jpg");
////
////         읽고 쓰기
//while(true) {
//    int data = in.read();
//    if(data == -1) {
//        break;
//        }
//    fos.write(data);
//        } // end while
//in.close();
//fos.close();
//clintSocket.close();
//
//
////         클라이언트에서 보낸 데이터 3개 중 3개 읽기
////         65, 66, 67 출력 => read 성공
////        System.out.println(in.read());
////        System.out.println(in.read());
////        System.out.println(in.read());
////        }
////    }
////}