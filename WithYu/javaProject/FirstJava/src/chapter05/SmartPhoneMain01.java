package chapter05;

public class SmartPhoneMain01 {
	
	public static void main(String[] args) {
		
		SmartPhone sp = new SmartPhone(); // SmartPhone 클래스로 객체 생성
		
		System.out.println("> color : " + sp.color); // 참조변수를 이용해 객체의 color변수 참조
		System.out.println("> size : " + sp.size); // 참조변수를 이용해 객체의 size 변수 참조		
		System.out.println("> volume : " + sp.volume); // 참조변수를 이용해 객체의 color변수 참조
		
		sp.call(); // 참조변수를 이용해 객체의 메소드 호출 
							 // 메소드 자체에 syso가 있기 때문에
  						 // 변수와 달리 여기엔 syso가 없다

	}
}