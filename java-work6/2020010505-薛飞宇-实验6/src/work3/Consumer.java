package work3;

public class Consumer implements Runnable{
	GoodsShelf goodsShelf;
	int i;
	int sleep;
	public Consumer() {
		// TODO Auto-generated constructor stub
		sleep = 10;
		i = 1;
	}
	void setGoodsShelf(GoodsShelf goodsShelf) {
		this.goodsShelf = goodsShelf;
	}
	
	void setSleep(int sleep) {
		this.sleep = sleep;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int id = 0;
		while(i<=100) {
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			synchronized (goodsShelf) {
				try {
					id = goodsShelf.consume().name;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"消费了第"+id+"个产品");
				i++;
			}
			
		}
	}
}
