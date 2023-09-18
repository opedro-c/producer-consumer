import java.util.Stack;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    Stack<Integer> stack;

    public Consumer(Stack<Integer> stack) {
        this.stack = stack;
    }

    public void consume() {
        if (!stack.empty()) {
            Integer valueConsumed = stack.pop();
            System.out.printf("Consumed: %d%n", valueConsumed);
        } else {
            System.out.println("Nothing to consume");
        }
    }

    @Override
    public void run() {
        consume();
    }
}
