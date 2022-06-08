package work2;


public class WorkShop implements Runnable{

	private int all = 800;
	private int now = 1;
	
	synchronized void produce() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(now<=all) {
			System.out.println("车间" + Thread.currentThread().getName() + "生产第"+ now++ +"个产品");
		}
	}
	@Override
	public void run() {
		int cnt = 0;
		while(now<=all) {
			produce();
			cnt++;
		}
		System.out.println("统计：车间"+Thread.currentThread().getName()+"生产了"+cnt+"个产品");
	}
}
