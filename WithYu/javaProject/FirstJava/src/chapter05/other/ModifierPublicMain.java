package chapter05.other; // 메인 메소드에서 생성한 인스턴스 다른 패키지

import chapter05.ModifierPublic;

public class ModifierPublicMain {

	public static void main(String[] args) {
		
		ModifierPublic mp = new ModifierPublic();
		mp.name = "박성환"; // 접근 가능
		mp.age = 30; // 접근 가능
		mp.tell(); // 접근 가능
	}
}