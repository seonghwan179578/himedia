package chapter05;

public class SingletonMain {

	public static void main(String[] args) {

		// Singleton s = new Singleton(); // 오류
		Singleton s = Singleton.getInstance(); // 인스턴스를 얻을 수 있는 유일한 방법ㅁ
	}
}