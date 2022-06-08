package work1;

public class Rectangle extends Shape{
	double a,b;
	
	
	public Rectangle(double aa, double bb) {
		a = aa;
		b = bb;
	}
	@Override
	double getarea() {
		return a*b;
	}
	
}
