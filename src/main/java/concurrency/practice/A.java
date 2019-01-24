package concurrency.practice;

import java.util.PriorityQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class A {


    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    static class DelayQueue<E extends Delayed> {

        final transient ReentrantLock lock = new ReentrantLock();
        final PriorityQueue<E> pq = new PriorityQueue<>();
        final Condition available = lock.newCondition();
        Thread leader = null;

        public DelayQueue() {}

        public boolean put(E e) {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try {
                pq.offer(e);
                if (pq.peek() == e) {
                    leader = null;
                    available.signal();
                }
                return true;
            } finally {
                lock.unlock();
            }
        }

        public E take() throws InterruptedException {
            final ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try {
                while (true) {
                    E first = pq.peek();
                    if (first == null)
                        available.await();
                    else {
                        long delay = first.getDelay(TimeUnit.NANOSECONDS);
                        if (delay <= 0)
                            return pq.poll();
                        first = null; // don't retain reference while waiting

                        if (leader != null)
                            available.await();
                        else {
                            Thread thisThread = Thread.currentThread();
                            leader = Thread.currentThread();
                            try {
                                available.awaitNanos(delay);
                            } finally {
                                if (leader == thisThread)
                                    leader = null;
                            }
                        }

                    }
                }
            } finally {
                if (leader == null && pq.peek() != null)
                    available.signal();
                lock.unlock();
            }
        }
    }
}
