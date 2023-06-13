package chapter05;

public class ModifierPrivateMain {

	public static void main(String[] args) {

		ModifierPrivate mp = new ModifierPrivate();
		mp.name = "박성환"; // 현재 클래스에서는 인스턴스 변수에 접근이 불가
		mp.tell(); // ModifierPrivate 클래스의 인스턴스변수 name의 접근제어자가
	} // private이기 때문에 다른 클래스에서 접근 불가 -> 에러 발생
}