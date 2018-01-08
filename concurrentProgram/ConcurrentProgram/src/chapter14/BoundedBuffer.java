package chapter14;

public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {

	protected BoundedBuffer(int capacity) {
		super(capacity);
		// TODO Auto-generated constructor stub
	}
	
	//阻塞并直到：not-full
	public synchronized void put(V v) throws InterruptedException {
		while (isFull()) 
			wait();
		doPut(v);
		notifyAll();
	}
	
	//阻塞并直到：not-empty
	public synchronized V take() throws InterruptedException {
		while (isEmpty()) 
			wait();
		V v = doTake();
		notifyAll();
		return v;
	}
}
