package chapter6;

public enum BasicOperation implements Operation {
	PLUS("+") {
		public double apply(double x, double y) { return x + y; }
	};
	
	private final String symbol;
	BasicOperation (String symbol) {
		this.symbol = symbol;
	}
	@Override public String toString() {
		return symbol;
	}
	public static void main(String[] args) {
		double x = 1;
		double y = 2;
		test(BasicOperation.class, x, y);
	}
	
	private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
		for (Operation op : opSet.getEnumConstants()) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}
}
