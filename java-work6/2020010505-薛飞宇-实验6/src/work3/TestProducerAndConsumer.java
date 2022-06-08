package work3;

public class TestProducerAndConsumer {
	public static void main(String[] args) {
		GoodsShelf goodsShelf = new GoodsShelf(10);
		
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		producer.setSleep(5);
		consumer.setSleep(10);
		
		producer.setGoodsShelf(goodsShelf);
		consumer.setGoodsShelf(goodsShelf);
		
		Thread producerThread1 = new Thread(producer, "生产者1");
		Thread producerThread2 = new Thread(producer, "生产者2");
		
		Thread consumerThread1 = new Thread(consumer, "消费者1");
		Thread consumerThread2 = new Thread(consumer, "消费者2");
		Thread consumerThread3 = new Thread(consumer, "消费者3");
		
		
		producerThread1.start();
		producerThread2.start();
		
		consumerThread1.start();
		consumerThread2.start();
		consumerThread3.start();
	}
}
