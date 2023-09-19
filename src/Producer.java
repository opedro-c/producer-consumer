import java.util.List;

public class Producer implements Runnable {

    private List<Integer> list;
    private Integer counter = 0;

    public Producer(List<Integer> list) {
        this.list = list;
    }

    public void produce() {
        
        for (int i = 0; i < 50; i++) {
			addNumberToList();
			printValueProduced();
//			sleep(200);
		}
    }

	private void printValueProduced() {
		System.out.printf("Produced: %d%n", counter);
	}

	private void sleep(Integer milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void addNumberToList() {
		list.add(counter++);
	}

	@Override
	public void run() {
		produce();
	}

	
}
