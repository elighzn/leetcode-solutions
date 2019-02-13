package concurrency.practice;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Task implements Delayed {
	String name;
	long startTime;

	public Task(long delay, String name) {
		this.startTime = System.currentTimeMillis() + delay;
		this.name = name;
	}

	public String toString() {
		return "Task " + name + "_" + startTime;
	}

	@Override
	public int compareTo(Delayed o) {
		return Long.compare(startTime, ((Task) o).startTime);
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = startTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}
}