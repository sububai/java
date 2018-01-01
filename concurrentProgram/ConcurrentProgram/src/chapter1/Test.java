package chapter1;

class Widgt{
	public synchronized void doSomething(){
		System.out.println("in Widgt doSomething");
	}
}

class LoggingWidgt extends Widgt {
	public synchronized void doSomething() {
		System.out.println(toString() + ": calling doSomething");
		super.doSomething();
	}
}

public class Test {
	public static void main (String[] args) {
		LoggingWidgt l = new LoggingWidgt();
		l.doSomething();
	}
}
