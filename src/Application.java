import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws InterruptedException {
    	List<Integer> list = new ArrayList<Integer>();
    	Thread producer = new Thread(new Producer(list));
    	Thread consumer = new Thread(new Consumer(list));
    	
    	producer.setPriority(Thread.MIN_PRIORITY);
    	consumer.setPriority(Thread.MAX_PRIORITY);
    	
    	consumer.start();
    	producer.start();
    	
    	producer.join();
    	consumer.join();
    	
    	System.out.println(String.format(
    			"List: %s%n" +
    			"Length: %d",
    			list.toString(), list.size()
    	));
    }
}
