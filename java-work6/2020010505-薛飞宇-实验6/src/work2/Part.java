package work2;

public class Part {

	public static void main(String[] args) {
		WorkShop task = new WorkShop();
		//target对象是同一个，所以all是给三个线程共享的资源
		//但是如果用thread继承的话，all就不是对象的共享资源，解决方案是all设置为静态成员变量
		Thread workShop1 = new Thread(task, "1");
		Thread workShop2 = new Thread(task, "2");
		Thread workShop3 = new Thread(task, "3");
		Thread workShop4 = new Thread(task, "4");
		workShop1.start();
		workShop2.start();
		workShop3.start();
		workShop4.start();
	}

}
