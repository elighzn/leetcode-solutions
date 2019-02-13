package concurrency.practice;

import java.util.Random;

public class TaskProducer implements Runnable {
	private final Random ran = new Random();
	private DelayQueue<Task> dq;

	public TaskProducer(DelayQueue<Task> dq) {
		this.dq = dq;
	}

	public void run() {
		while (true) {
			Task task = new Task(ran.nextInt(10000), "Task " + ran.nextInt());
			System.out.println("Queueing " + task);
			try {
				int N = dq.size();
				System.out.println("Queue size: " + N);
				if (N < 20)
					dq.put(task);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// try {
				// Thread.sleep(100);
				// } catch (Exception ex) {
				//
				// }
			}

		}
	}
}
