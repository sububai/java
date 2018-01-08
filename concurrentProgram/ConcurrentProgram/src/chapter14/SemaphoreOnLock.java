package chapter14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreOnLock {
	private final Lock lock = new ReentrantLock();
	//条件谓词：permitsAvailable (permits > 0)
	private final Condition permitsAvailable = lock.newCondition();
	private int permits;
	
	public SemaphoreOnLock(int initalPermits) {
		// TODO Auto-generated constructor stub
		lock.lock();
		try {
			permits = initalPermits;
		} finally {
			lock.unlock();
		}
	}
	
	//阻塞并直到：permitsAvailable
	public void acquire() throws InterruptedException {
		lock.lock();
		try {
			while (permits <= 0)
				permitsAvailable.await();
			--permits;
		} finally {
			lock.unlock();
		}
	}
	
	public void release() {
		lock.lock();
		try {
			++permits;
			permitsAvailable.signal();
		} finally {
			lock.unlock();
		}
	}

}
