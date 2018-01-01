package ch11;

class Candy {
	static {
		System.out.println("Loading Candy");
	}
}

class Gum {
	static {
		System.out.println("Loading Gum");
	}
}

class Cookie {
	static {
		System.out.println("Loading Cookie");
	}
}

public class SweetShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("inside main");
		new Candy();
		System.out.println("After createing Candy");
		try {
			//必须是完整的类名，包括包
			Class.forName("ch11.Gum");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("After Class forName(\"Gum\")");
		new Cookie();
		System.out.println("After creating Cookie");
	}

}
