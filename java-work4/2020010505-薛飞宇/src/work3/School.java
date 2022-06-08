package work3;

import java.io.Serializable;

public class School implements Serializable{
	String name;
	
	
	public School(String s) {
		// TODO Auto-generated constructor stub
		name = s;
	}
	void setName(String na) {
		name = na;
	}
	@Override
	public String toString() {
		return "School [name=" + name + "]";
	}
	
}
