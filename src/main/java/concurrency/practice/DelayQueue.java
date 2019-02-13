package concurrency.practice;

import java.util.PriorityQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DelayQueue<E extends Delayed> {
	private transient final ReentrantLock lock = new ReentrantLock();
	private final PriorityQueue<E> pq = new PriorityQueue<E>();
	private final Condition available = lock.newCondition();
	private Thread leader = null;

	public DelayQueue() {
	}

	public void put(E e) {
//		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
			pq.offer(e);
			if (pq.peek() == e) {
				leader = null;
				available.signal();
			}
		} finally {
			lock.unlock();
		}
	}

	public E take() throws Exception {
//		final ReentrantLock lock = this.lock;
		lock.lockInterruptibly();
		try {
			while (true) {
				E first = pq.peek();
				if (first == null)
					available.await();
				else {
					long delay = first.getDelay(TimeUnit.MILLISECONDS);
					if (delay <= 0)
						return pq.poll();
					first = null;
					if (leader != null)
						available.await();
					else {
						Thread thread = Thread.currentThread();
						leader = thread;
						try {
							available.awaitNanos(delay);
						} finally {
							if (leader == thread)
								leader = null;
						}
					}
				}
			}
		} finally {
			if (leader == null && pq.peek() != null) {
				available.signal();
			}
			lock.unlock();
		}
	}
	
	public int size() throws Exception {
		lock.lockInterruptibly();
		try {
			return pq.size();
		} finally {
			lock.unlock();
		}
	}
}
