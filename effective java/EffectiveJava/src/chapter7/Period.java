package chapter7;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public final class Period implements Serializable{
	private Date start;
	private Date end;
	
	/**
	 * @param start the beginning of the period
	 * @param end the end of the period; must not precede start
	 * @throws IllegalArgumentException if start is after end
	 * @throws NullPointerException if start or end is null
	 */
	public Period (Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if (this.start.compareTo(this.end) > 0)
			throw new IllegalArgumentException(start + " after " + end);
		
	}
	public Date start() {
		return new Date(start.getTime());
	}
	public Date end() {
		return new Date(end.getTime());
	}
	
	@Override public String toString() { return start + " - " + end; }
	
	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		throw new InvalidObjectException("Proxy required");
	}
	
	private Object writeReplace() {
		return new SerializationProxy(this);
	}
	
	
	 private static class SerializationProxy implements Serializable {

			private static final long serialVersionUID = 1L;
			private final Date start;
			private final Date end;
			
			public SerializationProxy(Period p) {
				// TODO Auto-generated constructor stub
				this.start = p.start;
				this.end = p.end;
			}
			
			private Object readResolve() {
				return new Period(start, end);
			}
		}
}
