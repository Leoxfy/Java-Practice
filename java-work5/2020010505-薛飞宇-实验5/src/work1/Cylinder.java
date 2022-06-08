package work1;

public class Cylinder<T extends Shape>{
	T bottom;
	double height;
	
	public Cylinder(T bb, double hh) {
		bottom = bb;
		height = hh;
	}
	
	double getVolume(){
		return bottom.getarea()*height;
	}
	void print() {
		System.out.println("当前柱体的体积为：" + getVolume());
	}
	public static void main(String[] args) {
		Circle circle = new Circle(1);
		Cylinder<Circle> cylinder1 = new Cylinder<>(circle, 1);
		cylinder1.print();
		
		Rectangle rectangle = new Rectangle(3, 4);
		Cylinder<Shape> cylinder2 = new Cylinder<>(rectangle, 2);
		cylinder2.print();
	}
}
