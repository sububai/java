package chapter16;

public class PossibleReording {
	static int x = 0, y = 0;
	static int a = 0, b = 0;
	
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		Thread one = new Thread(new Runnable() {
			public void run() {
				a = 1;
				x = b;
			}
		});
		Thread other = new Thread(new Runnable() {
			public void run() {
				b = 1;
				y = a;
			}
		});
		one.start();
		other.start();
		one.join();
		other.join();
		System.out.println("( " + x + "," + y + " )");
	}

}
