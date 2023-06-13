
package chapter07;

public class SmartPhone2 extends Phone {

	String model;

	public SmartPhone2() {
	}

	public SmartPhone2(String phoneNumber, String model) {
		super(phoneNumber);
		this.model = model;
	}

	void game() {
		super.call(); // 상위클래스의 call()메소드를 호출
		System.out.println(model + " 게임을 합니다.");
	}

}
