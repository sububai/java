package chapter6;

public enum Planet {
	MERCURY(3.302e+23, 2.439e6),
	VENUS(4.869e+24, 6.052e6);
	
	private final double mass;
	private final double radius;
	private final double surfaceGravity;
	
	private static final double G = 6.67300E-11;
	Planet(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
		surfaceGravity = G * mass / (radius * radius);
	}
	
	public double mass() { return mass; }
	public double radius() { return radius; }
	public double surfaceGravity() { return surfaceGravity; }
	
	public double surfaceWeight(double mass) {
		return mass * surfaceGravity;
	}
	
}
