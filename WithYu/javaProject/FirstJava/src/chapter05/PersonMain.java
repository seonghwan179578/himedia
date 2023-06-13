package chapter05;

public class PersonMain {

	public static void main(String[] args) {
	
		Person person = new Person();
		
//		 person.name = "박성환"; // private 이었기 때문에 변수에 직접 참조는 불가능
		 person.setName("박성환");
		 person.setAge(30);
		 person.tell();
}
}