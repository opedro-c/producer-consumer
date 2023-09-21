import java.util.List;

public class Producer extends BaseThread implements Runnable {

    private Integer counter = 0;

    public Producer(List<Integer> list) {
        super(list);
    }

    public void produce() {
        
        for (int i = 0; i < 50; i++) {
			addNumberToList();
			printValueProduced();
			sleep(200);
		}
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
