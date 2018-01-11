package chapter3;

public class PhoneNumber implements Cloneable, Comparable<PhoneNumber>{
	private final short areaCode;
	private final short prefix;
	private final short lineNumber;
	
	//Lazily initialized, cached hashCode
	private volatile int hashCode;
	
	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		rangeCheck(areaCode, 999, "area code");
		rangeCheck(prefix, 999, "prefix");
		rangeCheck(lineNumber, 9999, "line number");
		this.areaCode = (short) areaCode;
		this.prefix = (short) prefix;
		this.lineNumber = (short) lineNumber;
	}

	private void rangeCheck(int arg, int max, String name) {
		// TODO Auto-generated method stub
		if (arg < 0 || arg > max)
			throw new IllegalArgumentException(name + ": " + arg);
	}
	
	@Override public boolean equals (Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PhoneNumber))
			return false;
		PhoneNumber pn = (PhoneNumber) o;
		return pn.lineNumber == lineNumber && pn.prefix == prefix && pn.areaCode == areaCode;
	}
	
	@Override public int hashCode() {
		int result = hashCode;
		if (result == 0) {
			result = 17;
			result = 31 * result + areaCode;
			result = 31 * result + prefix;
			result = 31 * result + lineNumber;
			hashCode = result;
		}
		return result;
	}
	
	@Override public PhoneNumber clone() {
		try {
			return (PhoneNumber) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	@Override
	public int compareTo(PhoneNumber pn) {
		// TODO Auto-generated method stub
		if (areaCode < pn.areaCode)
			return -1;
		if (areaCode > pn.areaCode)
			return 1;
		if (prefix < pn.prefix)
			return -1;
		if (prefix > pn.prefix)
			return 1;
		if (lineNumber < pn.lineNumber)
			return -1;
		if (lineNumber > pn.lineNumber)
			return 1;
		return 0;
	}
	
	
}
