package chapter4;

import java.util.List;

public class AbstractList {
	static List<Integer> intArrayList(final int[] a) {
		if (a == null)
			throw new NullPointerException();
		return new java.util.AbstractList<Integer>() {
			public Integer get(int i) {
				return a[i];
			}
			@Override public Integer set(int i, Integer val) {
				int oldVal = a[i];
				a[i] = val;
				return oldVal;
			}
			public int size() {
				return a.length;
			}
		};
	}
}
