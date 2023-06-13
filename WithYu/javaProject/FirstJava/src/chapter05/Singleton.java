package chapter05;

public class Singleton {

	// 1. 외부 인스턴스에서 인스턴스를 생성하지 못하도록 처리 : 생성자에 private 접근제어자 사용
	private Singleton() {
	}

	// 2. 사용할 인스턴스를 클래스 내부에 생성
	private static Singleton s = new Singleton(); // Singleton.s=null;
													// Singleton 메소드에 아무 내용도 없기 때문

	// 3. 외부에서 만들어진 참조값을 사용할 수 있도록 참조값을 제공하는 메소드
	public static Singleton getInstance() {
		if (s == null) {
			s = new Singleton();
		}
		return s;
	}
}