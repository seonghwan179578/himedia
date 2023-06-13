package chapter05;

public class SmartPhone2 {

	String color; // 속성 : 스마트폰의 색상
	float size; // 스마트폰의 사이즈
	int volume; // 속성 : 음량 크키

	// 초기화에 필요한 데이터를 받기 위해 매개변수를 정의한 생성자
	public SmartPhone2(String color, float size, int volume) { // 색상, 사이즈, 볼륨 크기 값을 받아 초기화
		this.color = color;
		this.size = size;
		this.volume = volume;
	}

	public SmartPhone2(String color, float size) { // 색상, 사이즈 값을 받아 초기화
																								 // 매개 변수 개수를 다르게 하여 같은 이름의 메소드를 오버로딩
		this.color = color;
		this.size = size;
		this.volume = 0;
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
		System.out.println(">스마트폰의 볼륨 크기 :" + volume);
	}

	public static void main(String[] args) {
		SmartPhone2 sp = new SmartPhone2("RED", 10.5f, 0);
		sp.printSpec();
		SmartPhone2 sp1 = new SmartPhone2("GOLD", 4.1f);
		sp1.printSpec();
	}
}