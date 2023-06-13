package chapter07;

public class Phone {

	String phoneNumber;

	public Phone() {
	}

	public Phone(String phoneNumber) { // phoneNumber 변수를 초기화 하는 생성자
		this.phoneNumber = phoneNumber;

	}

	void call() {
		System.out.println(phoneNumber + "에서 전화를 겁니다.");
	}
}