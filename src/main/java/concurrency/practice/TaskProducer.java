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
			dq.put(task);
			try {
				Thread.sleep(5000);
			} catch (Exception ex) {

			}
		}
	}
}
