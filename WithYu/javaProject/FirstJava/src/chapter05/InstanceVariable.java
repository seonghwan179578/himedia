package chapter05;

public class InstanceVariable {

	String name = "KING"; // 인스턴스 변수 name 선언
	int age = 12; // 인스턴스 변수 age 선언

	void tellName() {
		System.out.println("나의 이름은 " + name + "입니다."); // 멤버변수인 name을 참조한다
	}

	void tellAge() {
		System.out.println("나는 " + age + "살 입니다."); // 멤버변수인 age를 참조한다
	}

	public static void main(String[] args) {

		InstanceVariable variable = new InstanceVariable();
		variable.tellName(); // 인스턴스 메소드 호출
		variable.tellAge(); // 인스턴스 메소드 호출
	}
}