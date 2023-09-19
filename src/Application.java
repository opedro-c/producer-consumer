import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Application {

    public static void main(String[] args) throws InterruptedException {
    	
    	List<Integer> list = new ArrayList<Integer>();
    	Semaphore semaphore = new Semaphore(1, true);
    	Thread producer = new Thread(new Producer(list, semaphore));
    	Thread consumer = new Thread(new Consumer(list, semaphore));
    	
    	producer.setPriority(Thread.MIN_PRIORITY);
    	consumer.setPriority(Thread.MAX_PRIORITY);
    	
    	producer.start();
    	consumer.start();
    	
    	producer.join();
    	consumer.join();
    	
    	printListState(list);
    }

	private static void printListState(List<Integer> list) {
		System.out.println(String.format(
    			"List: %s%n" +
    			"Length: %d",
    			list.toString(), list.size()
    	));
	}
}
