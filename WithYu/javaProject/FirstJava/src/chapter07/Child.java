package chapter07;

public class Child extends Parent {

	int num = 100;

	void showData() {
		System.out.println("조상 클래스의 변수 num=" + super.num);
		System.out.println("자손 클래스 인스턴스 변수 num=" + this.num);
		// super와 this를 이용하여 같은 이름의 서로 다른 변수를 구분하여 출력
	}
}