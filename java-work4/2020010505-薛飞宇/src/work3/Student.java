package work3;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable{
	private int id;
	private String name;
	private int age;
	School school;
	
	public Student() {
		
	}
	
	public Student(int id, String name, int age, String s) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		school = new School(s);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", school=" + school + "]";
	}

	
	
}
