package chapter3;

import java.util.*;

public class ThreeStooges {
	private final Set<String> stooges = new HashSet<String>();
	
	public ThreeStooges() {
		stooges.add("Moe");
		stooges.add("Larry");
		stooges.add("Curly");
	}
	
	public boolean isStooge(String name) {
		return stooges.contains(name);
	}
	public static void main(String[] args) {
		ThreeStooges t = new ThreeStooges();
		System.out.println(t.isStooge("a"));
	}
}
