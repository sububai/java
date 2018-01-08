package chapter14;

public class SleepBoundedBuffer<V> extends BaseBoundedBuffer<V> {

	private static final long SLEEP_GRANULARITY = 0;

	protected SleepBoundedBuffer(int capacity) {
		super(capacity);
		// TODO Auto-generated constructor stub
	}
	
	public void put(V v) throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (!isFull()) {
					doPut(v);
					return ;
				}
			}
			Thread.sleep(SLEEP_GRANULARITY);
		}
	}
	
	public V take() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (!isEmpty()) 
					return doTake();
			}
			Thread.sleep(SLEEP_GRANULARITY);
		}
	}

}
