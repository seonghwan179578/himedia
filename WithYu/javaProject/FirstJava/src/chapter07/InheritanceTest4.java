package chapter07;

public class InheritanceTest4 {

	public static void main(String[] args) {

		SmartPhone smartPhone = new SmartPhone("010-7777-7777", "IOS");
		// 조상 클래스로부터 상속받은 메소드
		smartPhone.call();

		// 자식 클래스에서 추가로 정의한 메소드
		smartPhone.game();
	}
}
