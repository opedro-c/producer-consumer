import java.util.List;
import java.util.concurrent.Semaphore;

public abstract class BaseThread {
	
	protected List<Integer> list;
	protected Semaphore semaphore;
	
	public BaseThread(List<Integer> list, Semaphore semaphore) {
		super();
		this.list = list;
		this.semaphore = semaphore;
	}

	protected void sleep(Integer milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void down() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void up() {
		semaphore.release();
	}
}
