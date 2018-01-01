package ch12;

class MyString implements Cloneable {
	String s = "abc";
	
	@Override
	public String toString () {
		return s;
	}
	
	public void concatenate (String tail) {
		s += tail;
	}
	
	@Override
	public Object clone () {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("clone failed");
		}
		return o;
	}
}

public class Test1 {

	public static void f(MyString x) {
		x.concatenate("test");
		System.out.println(x);
	}
	
	public static void g(MyString x ) {
		x = (MyString)x.clone();
		x.concatenate("test");
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyString x = new MyString();
		f(x);
		g(x);
	}

}
