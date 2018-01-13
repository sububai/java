package chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListTest {
	public static void swap(List<?> list, int i, int j) {
		swapHelper(list, i, j);
	}
	public static <E> void swapHelper(List<E> list, int i, int j) {
		list.set(i, list.set(j,list.get(i)));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strings = new ArrayList<>();
		unsafeAdd(strings, new String("21"));
		String s = strings.get(0);
		System.out.println(s);
	}
	
	public static void unsafeAdd(List<String> list, String o) {
		list.add(o);
	}
	
	static int numElementsInCommon(Set<?> s1, Set<?> s2) {
		int result = 0;
		for (Object o1 : s1) {
			if (s2.contains(o1))
				result++;
		}
		
		if(s1 instanceof Set) {
			result++;
		}
		return result;
	}
}
