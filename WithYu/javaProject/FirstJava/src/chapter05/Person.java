package chapter05;

public class Person {

	private String name; // 변수는 외부에서 직접 참조가 불가능하도록 private 적용
	private int age;

	// 변수에 값의 변경이나 반환을 위한 setter/getter 메소드는 public으로 정의해서 외부에서 접근이 가능하도록 정의
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void tell() {
		System.out.println("안녕하세요. " + age + "살 " + name + " 입니다.");
	}

}