package chapter1;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person {
	private final Date birthDate;
	private static final Date BOOM_START;
	private static final Date BOOM_END;
	
	public Person(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();
		gmtCal.set(1964, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = gmtCal.getTime();
	}
	
	public boolean isBabyBoomer() {		
		return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
	}

}
