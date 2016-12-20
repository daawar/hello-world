package concurrency_samples;

public class Count implements Runnable {

	private final long countMax;

	public Count(long count) {
		countMax = count;
	}

	@Override
	public void run() {
		long sum = 0;
		for (int i = 1; i <= countMax; i++) {
			sum += i;
		}
		System.out.println("sum: " + sum);
	}
}