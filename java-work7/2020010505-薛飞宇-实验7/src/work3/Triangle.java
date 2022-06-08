package work3;

import java.io.Serializable;

public class Triangle implements Serializable{
	double sideA;
	double sideB;
	double sideC;
	String area;
	public Triangle(double a, double b,double c) {
		this.sideA = a;
		this.sideB = b;
		this.sideC = c;
	}
	public boolean isLegal() {
		if(sideA + sideB > sideC && sideA +sideC > sideB && sideB + sideC > sideA) {
			return true;
		}
		return false;
	}
	public String calculateArea() {
		double p = (sideA+sideB+sideC)/2.0;
		area = ""+Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
		return area;
	}
}
