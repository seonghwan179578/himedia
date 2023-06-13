package chapter05;

import java.util.Date; // java.util.Date 클래스를 import

public class ImportDate {

	public static void main(String[] args) {
		java.util.Date now1 = new java.util.Date(); // Date 클래스의 기본 이름은 java.util.Date 이다
		Date now2 = new Date(); // Date 클래스를 import 해서 간단하게 Date로 쓸 수 있다
		System.out.println(now1);
		System.out.println(now2);
	}
}