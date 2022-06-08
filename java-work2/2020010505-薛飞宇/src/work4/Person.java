package work4;

public class Person {
	String name;
	String phoneNumber;
	public Person(String n, String p) {
		name = n;
		phoneNumber = p;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
}
