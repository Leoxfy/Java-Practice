package work1;

public class PrintB extends Thread{
	
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.print("B");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
