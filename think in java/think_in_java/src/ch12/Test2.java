package ch12;

class Battery implements Cloneable {
	int no;
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

class Toy implements Cloneable {
	Battery[] b;
	@Override
	public String toString () {
		String s = "";
		if (b == null) return "null";
		for (int i = 0; i < b.length; i++)
			s += b[i].no + " ";
		return s;
	}
	@Override
	public Object clone () {
		Object o = null;

		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("clone failed");
		}
		for (int i = 0; i < b.length; i++) {
			((Toy)o).b[i] = (Battery)(b[i].clone());
		}
		b = null;
		return o;
	}
}

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Toy t = new Toy();
		t.b = new Battery[5];
		for (int i = 0; i < t.b.length; i++) {
			t.b[i] = new Battery();
			t.b[i].no = i;
		}
			
		System.out.println(t);
		Toy c = (Toy)t.clone();
		System.out.println(t);
		System.out.println(c);
	}

}
