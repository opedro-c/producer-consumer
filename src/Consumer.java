import java.util.List;

public class Consumer extends BaseThread implements Runnable {

	private Integer lastRemoved;

	public Consumer(List<Integer> list) {
		super(list);
	}

	public void consume() {
		for (int i = 0; i < 50; i++) {
			if (!list.isEmpty()) {
				removeNumberFromList();
				printValueConsumed();
			} else {
				System.out.println("Nothing to consume");
			}
			sleep(200);
		}
	}

	private void printValueConsumed() {
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
