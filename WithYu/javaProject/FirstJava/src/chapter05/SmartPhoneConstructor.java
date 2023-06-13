package chapter05;

public class SmartPhoneConstructor {

	String color; // 속성 : 스마트폰의 색상
	float size; // 속성 : 스마트폰의 사이즈
	int volume; // 속성 : 음량 크기

	// 초기화에 필요한 데이터를 받기 위해 매개변수를 정의한 생성자
	public SmartPhoneConstructor(String color, float size, int volume) { // 색상, 사이즈, 볼륨크기 값을 받아 초기화
		this.color = color;
		this.size = size;
		this.volume = volume;
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

	public static void main(String[] args) {
		SmartPhoneConstructor sp = new SmartPhoneConstructor("RED", 10.5f, 0);
		System.out.println("> color : " + sp.color); // 생성자를 통해 초기화된 color 변수 참조
		System.out.println("> size : " + sp.size); // 생성자를 통해 초기화된 size 변수 참조
		System.out.println(">volume : " + sp.volume); // 생성자를 통해 초기화된 volume 변수 참조
		sp.call();
	}

}