import java.util.List;
import java.util.concurrent.Semaphore;

public class Producer extends BaseThread implements Runnable {

	private int counter = 0;

	public Producer(List<Integer> list, Semaphore semaphore) {
		super(list, semaphore);
	}

	public void produce() {
		for (int i = 0; i < 50; i++) {
			down();
			addNumberToList();
			printValueProduced();
			up();
			sleep(200);
		}
		System.out.println("Producer: Done");
	}

	private void printValueProduced() {
		System.out.printf("Produced: %d%n", counter);
	}

	private void addNumberToList() {
		list.add(counter++);
	}

	@Override
	public void run() {
		produce();
	}

}
