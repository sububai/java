/**
 * 
 */
package ch12;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author sububai
 *
 */

class Int {
	private int i;
	public Int(int i) {
		this.i = i;
	}
	public void increment() {
		i++;
	}
	public String toString() {
		return Integer.toString(i);
	}
}

public class Cloning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector v = new Vector();
		for (int i = 0; i < 10; i++)
			v.addElement(new Int(i));
		System.out.println("v:" + v);
		Vector v2 = (Vector)v.clone();
		for (Enumeration e = v2.elements(); e.hasMoreElements(); )
			((Int)e.nextElement()).increment();
		System.out.println("v:" + v);
		
	}

}
