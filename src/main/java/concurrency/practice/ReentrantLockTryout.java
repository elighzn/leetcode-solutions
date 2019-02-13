package concurrency.practice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTryout {

	static class Worker implements Runnable {
		String name;
		ReentrantLock lock;

		Worker(ReentrantLock l, String n) {
			name = n;
			lock = l;
		}

		@Override
		public void run() {
			boolean done = false;
			while (!done) {
				// Getting Outer Lock
				boolean ans = lock.tryLock();
				if (!ans) {
					waitForLock();
					continue;
				}

				try {
					Date d = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
					System.out.println(
							"task name - " + name + " outer lock acquired at " + ft.format(d) + " Doing outer work");
					Thread.sleep(1500);

					// Getting Inner Lock
					lock.lock();
					try {
						d = new Date();
						ft = new SimpleDateFormat("hh:mm:ss");
						System.out.println("task name - " + name + " inner lock acquired at " + ft.format(d)
								+ " Doing inner work");
						System.out.println("Lock Hold Count - " + lock.getHoldCount());
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						// Inner lock release
						System.out.println("task name - " + name + " releasing inner lock");

						lock.unlock();
					}
					System.out.println("Lock Hold Count - " + lock.getHoldCount());
					System.out.println("task name - " + name + " work done");

					done = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					// Outer lock release
					System.out.println("task name - " + name + " releasing outer lock");

					lock.unlock();
					System.out.println("Lock Hold Count - " + lock.getHoldCount());
				}
			}
		}

		void waitForLock() {
			System.out.println("task name - " + name + " waiting for lock");
			try {//				lock.tryLock(1500, TimeUnit.MILLISECONDS);
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	static final int MAX_T = 2;

	public static void main(String[] args) {
		ReentrantLock rel = new ReentrantLock();
		ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
		Runnable w1 = new Worker(rel, "Job1");
		Runnable w2 = new Worker(rel, "Job2");
		Runnable w3 = new Worker(rel, "Job3");
		Runnable w4 = new Worker(rel, "Job4");
		pool.execute(w1);
		pool.execute(w2);
		pool.execute(w3);
		pool.execute(w4);
		pool.shutdown();
	}
}
