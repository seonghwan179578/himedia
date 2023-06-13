package chapter05;

// 클래스의 구조 - 스마트폰 클래스 정의
public class SmartPhone {

	String color = "white"; // 속성 : 스마트폰의 색상
	float size = 5.7f; // 속성 : 스마트폰의 사이즈
	int volume = 0; // 속성 : 음량 크기
	
	void call() { // 기능 : 전화걸기
		System.out.println("전화걸기");
	}
	void volumeUp() { // 기능 : 음량 키우기
		volume +=1;     // int타입 변수 'volume'의 값이 0으로
								    // 설명되었기 때문에 0부터 1씩 증가
	}
	
	void volumeDown() { // 음량 낮추기 
		volume -=1;       // int타입 변수 'volume'의 값이 0으로
									 		// 설명되었기 때문에 0부터 1씩 감소
	}
}