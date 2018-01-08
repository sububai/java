package chapter14;

public class TreadGate {
	private boolean isOpen;
	private int generation;
	
	public TreadGate() {
		// TODO Auto-generated constructor stub
	}

	public synchronized void close() {
		isOpen = false;
	}
	
	public synchronized void open() {
		++generation;
		isOpen = true;
		notifyAll();
	}
	
	public synchronized void await() throws InterruptedException {
		int arrivalGeneration = generation;
		while (!isOpen && arrivalGeneration == generation)
			wait();
	}
}
