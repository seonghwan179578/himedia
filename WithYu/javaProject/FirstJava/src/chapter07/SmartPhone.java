package chapter07;

public class SmartPhone extends Phone { // Phone 클래스를 상속
										// SmartPhone이 Phone 클래스의 자식 클래스

	String model;

	public SmartPhone() {

	}

	public SmartPhone(String phoneNumber, String model) {
		super(phoneNumber); // 상위클래스의 생성자 호출
		this.model = model;
	}

	void game() {
		System.out.println(model + " 게임을 합니다.");
	}
}