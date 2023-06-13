package chapter05;

public class AdderMain {

	public static void main(String[] args) {

		Adder adder = new Adder(); // 객체 생성
		
		System.out.println(adder.add(10, 20)); // add(int n1, int n2) 호출 
																				   // return 값이 n1 + n2이므로 10+20=30
		System.out.println(adder.add(10.1f, 20.2f)); // add(float n1, float n2) 호출
																						  	 // return 값이 n1+n2이므로
																								 // 10.1+20.2=30.300001
	}

}