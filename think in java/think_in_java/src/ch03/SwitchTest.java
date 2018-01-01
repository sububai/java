package ch03;

public class SwitchTest {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			switch(i) {
			case 0: System.out.println(i);
			case 1: System.out.println(i);
			case 2: System.out.println(i);
			}
		}
		//? : 以高精度为准
		System.out.println( true ? 9 : 9.08);
	}
}
