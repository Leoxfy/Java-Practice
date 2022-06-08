package work1;

public class Circle extends Shape{
	static final double pi = 3.1415926;
	double r;
	
	
	public Circle(double rr) {
		r = rr;
	}
	@Override
	double getarea() {
		return pi*r*r;
	}

}
