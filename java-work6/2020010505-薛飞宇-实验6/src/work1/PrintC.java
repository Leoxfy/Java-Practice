package work1;

public class PrintC extends Thread{
	
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.print("C");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
