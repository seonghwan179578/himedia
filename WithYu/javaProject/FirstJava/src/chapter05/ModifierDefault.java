package chapter05;

public class ModifierDefault {

	String name; // 클래스의 인스턴스 변수는 같은 패키지 내부에서만 접근 가능
	int age;

	void tell() {
		System.out.println("안녕하세요. " + age + "살 " + name + "입니다.");
	}
}