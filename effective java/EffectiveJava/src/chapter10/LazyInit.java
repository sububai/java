package chapter10;

public class LazyInit {
	static class FieldType {
		
	}
	
	private static FieldType computeFieldValue() {
		return new FieldType();
	}
	
	//Normal init
	private final FieldType field1 = computeFieldValue();
	
	//Lazy initialization of instance of field - synchronized access
	private FieldType field2;
	synchronized FieldType getField2() {
		if (field2 == null)
			field2 = computeFieldValue();
		return field2;
	}
	
	//Lazy initialization holder class idiom for static fields
	private static class FieldHolder {
		static final FieldType field3 = computeFieldValue();	
	}
	static FieldType getField3() { return FieldHolder.field3; }
	
	//Double-check idiom for lazy initialization of instance fields
	private volatile FieldType field4;
	FieldType getField4() {
		FieldType result = field4;
		if (result == null) {	//first check (no locking)
			synchronized(this) {
				result = field4;
				if (result == null) 
					field4 = result = computeFieldValue();
			}
		}
		return result;
	}
	
	//Single-check idiom - can cause repeated initialization
	private volatile FieldType field5;
	private FieldType getField5() {
		FieldType result = field5;
		if (result == null)
			field5 = result = computeFieldValue();
		return result;
	}

}
