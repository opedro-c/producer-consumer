import java.util.List;
import java.util.concurrent.Semaphore;

public class Consumer extends BaseThread implements Runnable {

	private int lastRemoved;

	public Consumer(List<Integer> list, Semaphore semaphore) {
		super(list, semaphore);
	}

	public void consume() {
		for (int i = 0; i < 50; i++) {
			down();
			if (!list.isEmpty()) {
				removeNumberFromList();
				printValueRemoved();
			} else {
				System.out.println("Nothing to consume");
			}
			up();
			sleep(200);
		}
		System.out.println("Consumer: Done");
	}

	private void printValueRemoved() {
		System.out.printf("Consumed: %d%n", lastRemoved);
	}

	private void removeNumberFromList() {
		lastRemoved = list.remove(0);
	}

	@Override
	public void run() {
		consume();
	}
}
