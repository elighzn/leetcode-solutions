package concurrency.practice;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadExample {
	public static void main(String[] args) throws InterruptedException {
		final PC pc = new PC();
		// Create a thread object that calls pc.produce()
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Create another thread object that calls
		// pc.consume()
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {

					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Thread t3 = new Thread(new Runnable() {
		// @Override
		// public void run() {
		// try {
		// pc.consume();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		// });

		// Start both threads
		t1.start();
		t2.start();
		// t3.start();

		// t1 finishes before t2
		t1.join();
		t2.join();
		// t3.join();
	}

	// PC (Produce Consumer) class with produce() and
	// consume() methods.
	public static class PC {
		// Prints a string and waits for consume()
		private final ReentrantLock lock = new ReentrantLock();
		private final Condition available = lock.newCondition();

		public PC() {

		}

		public void produce() throws InterruptedException {
			try {
				lock.lock();
				System.out.println("producer thread running");

				available.await();

				System.out.println("Resumed");
			} finally {
				lock.unlock();
			}
		}

		// Sleeps for some time and waits for a key press. After key
		// is pressed, it notifies produce().
		public void consume() throws InterruptedException {
			// this makes the produce thread to run first.
			// Thread.sleep(1000);
			available.await();
			Scanner s = new Scanner(System.in);

			// synchronized block ensures only one thread
			// running at a time.
			try {
				lock.lock();
				System.out.println("Waiting for return key.");
				s.nextLine();
				System.out.println("Return key pressed");

				// notifies the produce thread that it
				// can wake up.
				notify();
				// Sleep
				Thread.sleep(2000);
				System.out.println("Sleeping is over");
			} finally {
				s.close();
				lock.unlock();
			}
		}
	}
}
