package work1;

public class MainThread {
	public static void main(String[] args) {
		PrintB thread1 = new PrintB();
		PrintC thread2 = new PrintC();
		thread1.start();
		thread2.start();
		printA();
	}
	
	public static void printA() {
		for(int i=0;i<20;i++) {
			System.out.print("A");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
