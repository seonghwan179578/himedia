package chapter05.other; // 상속하는 클래스와 다른 패키지

import chapter05.ModifierProtected;

public class ModifierProtectedExtends extends ModifierProtected {

	public static void main(String[] args) {

		ModifierProtectedExtends mpe = new ModifierProtectedExtends();
		mpe.name = "박성환"; // 접근제어자가 protected이기 때문에 상속 관계에서도 접근 가능
		// mpe.age = 28; // 접근제어자가 default이기 때문에 상속 관계에서도 접근 불가
		mpe.tell(); // 접근제어자가 protected이기 때문에 상속 관계에서도 접근 가능
	}

}