package ch03;

public class URShift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = -1;
		i >>>= 10;
		System.out.println(i);
		long l = -1;
		l >>>= 10;
		System.out.println(l);
		short s = -1;
		s >>>= 10;
		System.out.println(s);
		byte b = -1;
		b >>>= 10;
		System.out.println(b);
		//byte,short,char移位之前先转化何曾int并且不会发生无符号右移，都是有符号的
		byte b2 = -4;
		b2 >>>= 1;
		System.out.println(b2);
		System.out.println(b2 << 1);
	}

}
