package chapter9;

class Mountain {
	public void climb() {}
}

public class ArrayClimb {

	//基于异常的数组遍历
	public void arrayClimb(Mountain[] range) {
		try {
			int i = 0;
			while (true) 
				(range[i++]).climb();
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
		
		/*
		 * 正确的标准模式
		 * for (Moutain m : range)
		 * 	m.climb();
		 */
	}
}
