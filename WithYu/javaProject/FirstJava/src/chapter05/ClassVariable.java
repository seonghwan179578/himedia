package chapter05;

public class ClassVariable {

	static String name = "KING"; // 클래스 변수 name 선언
	static int age = 10; // 클래스 변수 age 선언

	void tellName() {
		System.out.println("나의 이름은 " + name + "입니다."); // 멤버변수인 name을 참조
	}

	void tellAge() {
		System.out.println("나는 " + age + "살 입니다."); // 멤버변수인 age를 참조
	}

	public static void main(String[] args) {
														   // 인스턴스 생성 없이
		System.out.println("이름 : " + ClassVariable.name); // 클래스이름.변수 형식으로 참조
		System.out.println("나이 : " + ClassVariable.age);  // 클래스이름.변수 형식으로 참조

		ClassVariable variable = new ClassVariable();
		System.out.println("이름 : " + variable.name); // 참조변수.변수 형식으로 참조
		System.out.println("나이 : " + variable.age);  // 참조변수.변수 형식으로 참조
		variable.tellName(); 						  // 인스턴스 내부의 멤버로 인식하기 때문에
		variable.tellAge();               // 메소드 호출에서도 변수를 참조해서 출력
	}
}