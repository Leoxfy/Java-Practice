package work3;

public class GoodsShelf {
	Product[] products;
	
	int size;
	int cnt;
	int i;
	int j;
	

	public GoodsShelf(int size) {
		this.size = size;
		products = new Product [size];
		cnt = 0;
		i = 0;
		j = 0;
	}
	


	//仅操作同步资源--货架
	public synchronized void produce(Product product) throws InterruptedException{
		// 如果货架满了，就要等待消费者消费
		while(cnt==products.length) {
			//通知消费者消费
			//生产者等待
			System.out.println("货架满，请等待消费者取走");
			wait();
		}
		//如果没有满，放入产品
		products[cnt] = product;
		cnt++;
		//可以通知消费者消费了
		notifyAll();
	}
	
	public synchronized Product consume() throws InterruptedException {
		//如果货架空，消费者等待生产者生产
		while(cnt==0) {
			//消费者等待
			System.out.println("货架空，请等待生产者生产");
			wait();
		}
		
		//如果不空，拿走一个产品
		cnt--;
		Product product = products[cnt];
		
		//消费完毕，通知生产者生产
		notifyAll();
		return product;
	}
}
