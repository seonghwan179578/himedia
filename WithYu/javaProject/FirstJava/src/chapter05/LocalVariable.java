package chapter05;

public class LocalVariable {
	
	void method(int num) { // 매개변수도 지역변수
                         // 메소드의 선언 부(method와 { 사이의 소괄호)에 정의하는 매개변수
                         // 이므로 지역변수 특징을 가지고 있음 
		
		int lv = 10; // 메소드 블록 안에서 정의하는 변수는 지역변수
		
		if (num > 10) {
			boolean check = true; // 블록 안에 정의되는 변수는 블록 안에서만 사용 가능한 지역변수
		} else {               
			boolean check = false;
		}
		
		for (int i = 0; i < 5; i++) { // for 정의 부(for와 중괄호 사이의 소괄호)에서 선언된
																  //  메소드는 for 블록 내부에서만
			System.out.println(i);      // 사용 가능한 지역변수
		}
		
		while (lv< 0) {
			int lv2 = 0;       // while 블록 안에 정의되는 변수는 while 블록 안에서만 사용 가능한
			System.out.println(lv2);                                              //  지역변수
		}		
	}
}