package ch12;
//Tests cloning to see if destination of handles are also cloned
//no

public class Snake implements Cloneable {
	private Snake next;
	private char c;
	Snake (int i, char x) {
		c = x;
		if (--i > 0)
			next = new Snake(i, (char)(x+1));
	}
	void increment() {
		c++;
		if (next != null)
			next.increment();
	}
	@Override
	public String toString() {
		String s = ":" + c;
		if (next != null)
			s += next.toString();
		return s;
	}
	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {}
		Snake p = ((Snake)o);
		Snake q = next;
		while (q != null) {
			p.next = (Snake)(q.clone());
			p = p.next;
			q = q.next;
			
		}
		return o;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Snake s = new Snake(5, 'a');
		System.out.println("s = " + s);
		Snake s2 = (Snake) s.clone();
		System.out.println("s2 = " + s2);
		s.increment();
		System.out.println("after s.increment, s2 = " + s2);
		System.out.println("s = " + s);
	}

}
