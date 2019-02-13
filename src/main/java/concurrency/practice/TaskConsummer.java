package concurrency.practice;

public class TaskConsummer implements Runnable {
	private DelayQueue<Task> dq;

	public TaskConsummer(DelayQueue<Task> dq) {
		this.dq = dq;
	}

	public void run() {
		while (true) {
			try {
				Task task = dq.take();
				System.out.printf("taking %s\n", task.toString());
			} catch (Exception ex) {

			}
		}
	}
}