package chapter14;

public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

	protected GrumpyBoundedBuffer(int capacity) {
		super(capacity);
		// TODO Auto-generated constructor stub
	}
	
	public synchronized void put(V v) throws BufferFullException {
		if (isFull())
			throw new BufferFullException();
		doPut(v);
	}
	public synchronized V take() throws BufferEmptyException {
		if (isEmpty())
			throw new BufferEmptyException();
		return doTake();
	}
}
