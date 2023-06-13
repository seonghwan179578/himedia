package chapter07;

public class InheritanceTest {

	public static void main(String[] args) {

		SmartPhone smartPhone = new SmartPhone(); // 조상 클래스(SmartPhone)로부터 상속 받은 변수
		smartPhone.phoneNumber = "010-0000-0000"; // Phone 클래스에 있는 변수 phoneNumber를,
													// 자식 클래스인 SmartPhone 클래스를 통해 인스턴스화 하여 사용하는 것
		smartPhone.model = "Google"; // 자식 클래스(SmartPhone)에서 추가로 정의한 변수
		smartPhone.call(); // 자식 클래스(SmartPhone)에서 추가로 정의한 메소드
		smartPhone.game();

	}

}