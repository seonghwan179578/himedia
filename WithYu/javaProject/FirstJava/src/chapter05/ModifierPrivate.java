package chapter05;

public class ModifierPrivate {

	private String name; // 클래스의 인스턴스 변수는 내부에서만 접근 가능
	private int age;
	
	void tell() {
		System.out.println("안녕하세요. " + age + "살" + name + "입니다");
	}
}