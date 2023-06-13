package chapter05;

public class MultInstance {

	public static void main(String[] args) {

		SmartPhone sp1 = new SmartPhone(); // SmartPhone 클래스로 객체 생성
		SmartPhone sp2 = new SmartPhone(); // SmartPhone 클래스로 객체 생성
		
		sp1.color = "Gold"; // 첫 번째 객체의 변수 color 속성값 대입
		sp1.size = 5.7f; // 첫 번째 객체의 변수 size 속성값 대입
		sp1.volume = 5; // 첫 번째 객체의 변수 volume 속성값 대입
		System.out.println("> color : " + sp1.color); // 첫 번째 객체의 변수들을 출력
		System.out.println("> size : " + sp1.size); // 
		System.out.println("> volume : " + sp1.volume); //
		
		sp2.color = "Black"; // 두 번째 객체의 color 속성값 대입
		sp2.size = 5.7f; // 두 번째 객체의 size 속성값 대입
		sp2.volume = 3; // 두 번째 객체의 volume 속성값 대입
		System.out.println("> color : " + sp2.color); // 두 번째 객체의 변수들을 출력
		System.out.println("> size : " + sp2.size); //
		System.out.println("> volume : " + sp2.volume); // 
		
		sp1.volumeUp(); // 첫 번째 객체의 volumeUp() 메소드 호출 : volume 5 -> 6 
		System.out.println("SmartPhone 1 객체의 volumeUp() 메소드를 호출했습니다.");
		System.out.println("> volume : " + sp1.volume); // 5가 아닌 6이 출력
		
		sp2.volumeDown(); // 두 번째 객체의 volumeDown() 메소드 호출 // volume 3 -> 2
		System.out.println("SmartPhone 2 객체의 volumeDown() 메소드를 호출했습니다.");
		System.out.println("> volume : " + sp2.volume); // 3이 아닌 2가 출력
		
		
		
		
		
		
	}

}