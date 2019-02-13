package concurrency.practice;

public class DelayQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DelayQueue<Task> q = new DelayQueue<>();
		new Thread(new TaskProducer(q)).start();
		new Thread(new TaskConsummer(q)).start();
		new Thread(new TaskConsummer(q)).start();
	}

}
