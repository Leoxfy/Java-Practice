package work3;

public class Producer implements Runnable{
	GoodsShelf goodsShelf;
	int i;
	int sleep;
	
	public Producer() {
		// TODO Auto-generated constructor stub
		i = 1;
		sleep = 10;
	}
	
	void setGoodsShelf(GoodsShelf goodsShelf) {
		this.goodsShelf = goodsShelf;
	}
	
	void setSleep(int sleep) {
		this.sleep = sleep;
	}
	//生产
	//run方法不能设置同步！
	@Override
	public void run() {
		while(i<=100) {
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(i>100) {
				break;
			}
			synchronized (goodsShelf) {
				try {
					goodsShelf.produce(new Product(i));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"生产了第"+i+"个产品");
				i++;
			}
			
		}
	}
	
}
