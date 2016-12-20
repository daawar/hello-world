package concurrency_samples;

import java.util.*;

public class Test {
	private static final List<Thread> threads = new ArrayList<>();

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			Count task = new Count(1000);
			Thread worker = new Thread(task);
			worker.setName("Thread " + (i + 1));
			threads.add(worker);
			worker.start();
		}

		int count = 0;
		do {

			count = 0;
			for (Thread thread : threads) {
				if (thread.isAlive()) {
					count += 1;
				}
			}
			System.out.println("Active threads: " + count);

		} while (count > 0);

	}
}