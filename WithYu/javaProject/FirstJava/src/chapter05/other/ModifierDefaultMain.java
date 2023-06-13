package chapter05.other; // 사용하는 인스턴스와 다른 패키지(chapter05 != chapter05.other)

import chapter05.ModifierDefault;

public class ModifierDefaultMain {

	public static void main(String[] args) {
		ModifierDefault mp = new ModifierDefault();
		mp.name = "박성환"; // 현재 클래스에서는 다른 패키지에서 접근하므로 인스턴스 변수에 접근 불가
		mp.age = 30; // 현재 클래스에서는 다른 패키지에서 접근하므로 인스턴스 변수에 접근 불가
		mp.tell(); // 현재 클래스에서는 다른 패키지에서 접근하므로 인스턴스 변수에 접근 불가

	}

}