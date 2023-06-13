package chapter05;

import chapter05.ModifierDefault; // import 패키지이름.클래스이름;

public class ModifierDefaultMain {

	public static void main(String[] args) {
		
		ModifierDefault mp = new ModifierDefault();
		
		mp.name = "박성환"; // 현재 클래스에서는 같은 패키지에서 접근하므로 인스턴스 변수에 접근 가능
		mp.age = 30; // 현재 클래스에서는 같은 패키지에서 접근하므로 인스턴스 변수에 접근 가능
		
		mp.tell(); // 현재 클래스에서는 같은 패키지에서 접근하므로 인스턴스 변수에 접근 가능
	}
}