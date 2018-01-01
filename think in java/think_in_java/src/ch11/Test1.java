package ch11;

public class Test1 {
	public static void main(String []args) throws ClassNotFoundException {
		Class temp = Class.forName(args[0]);
		while (temp != null) {
			System.out.println(temp.getName());
			temp = temp.getSuperclass();
		}
	}
	
}
