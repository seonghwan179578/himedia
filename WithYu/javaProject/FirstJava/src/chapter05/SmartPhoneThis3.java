package chapter05;

public class SmartPhoneThis3 {

	String color; // 속성 : 스마트폰의 색상
	float size; // 속성 : 스마트폰의 사이즈
	int volume; // 속성 : 음량 크기

	// 초기화에 필요한 데이터를 받기 위해 매개변수를 정의한 생성자
	public SmartPhoneThis3(String color, float size, int volume) { // 색상, 사이즈, 볼륨크기 값을 받아 초기화
		this.color = color;
		this.size = size;
		this.volume = volume;
	}

	public SmartPhoneThis3(String color, float size) { // 색상, 사이즈 값을 받아 초기화
		this(color, size, 0); // 매개 변수의 개수가 위의 메소드는 3개, 본 매소드는 2개로 달라서 오버로딩 가능
	}

	public SmartPhoneThis3(String color) { // 색상 값을 받아 초기화
		this(color, 5.7f, 0); // 매개변수의 개수가 위의 메소드는 2개, 본 매소드는 1개로 달라서 오버로딩 가능
	}

	public SmartPhoneThis3(float size) { // 사이즈 값을 받아 초기화
		this("BLACK", size, 0); // 매개변수의 개수가 위, 아래 모두 1개이지만 매개변수의 타입이 다르므로(String, float) 오버로딩 가능
	}

	void call() { // 기능 : 전화걸기
		System.out.println("전화걸기");
	}

	void volumeUp() { // 기능 : 음량 키우기
		volume += 1;
	}

	void volumeDown() { // 기능 : 음량 낮추기
		volume -= 1;
	}

	void printSpec() {
		System.out.println("> 스마트폰의 색상 : " + color);
		System.out.println(">스마트폰의 사이즈 : " + size);
		System.out.println("> 스마트폰의 볼륨 크기 : " + volume);
	}

	public static void main(String[] args) {
		SmartPhoneThis3 sp = new SmartPhoneThis3("RED", 10.5F, 0); // printSpec 매소드 자체에 syso가 있으므로 별도의 syso 없이도
																															 // Console창에 결과가 출력되는 것
		sp.printSpec();
		System.out.println();
		SmartPhoneThis3 sp1 = new SmartPhoneThis3("GOLD", 4.1F);
		sp1.printSpec();
		System.out.println();
		SmartPhoneThis3 sp2 = new SmartPhoneThis3("BLUE");
		sp2.printSpec();
		System.out.println();
		SmartPhoneThis3 sp3 = new SmartPhoneThis3(5.0f);
		sp3.printSpec();
	}

}