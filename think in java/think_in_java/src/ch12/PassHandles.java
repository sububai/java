/**
 * 
 */
package ch12;

/**
 * @author sububai
 *
 */
public class PassHandles {

	/**
	 * @param args
	 */
	static void f(PassHandles h) {
		System.out.println("h inside f():" + h);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PassHandles p = new PassHandles();
		System.out.println("p inside main():" + p);
		f(p);
		
	}

}
