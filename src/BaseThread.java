import java.util.List;

public abstract class BaseThread {

	protected List<Integer> list;

	public BaseThread(List<Integer> list) {
		super();
		this.list = list;
	}

	protected void sleep(Integer milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
