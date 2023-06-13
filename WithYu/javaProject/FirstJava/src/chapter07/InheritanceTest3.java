package chapter07;

public class InheritanceTest3 {

	public static void main(String[] args) {

		SmartPhone2 smartPhone = new SmartPhone2();

		// 조상 클래스로부터 상속받은 변수
		smartPhone.phoneNumber = "010-0000-0000";

		// 자식 클래스에서 추가로 정의한 변수
		smartPhone.model = "Google";

		// 자식 클래스에서 추가로 정의한 메소드
		smartPhone.game();
	}

}