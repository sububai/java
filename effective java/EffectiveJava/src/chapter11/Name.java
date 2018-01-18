package chapter11;

import java.io.Serializable;

public class Name implements Serializable {
	/*
	 * Last Name, Must be non-null
	 * @serial
	 */
	private final String lastName;
	/*
	 * First Name, Must be non-null
	 * @serial
	 */
	private final String firstName;
	/*
	 * Middle Name, or null if there is null
	 * @serial
	 */
	private final String middleName;
	public Name(String lastName, String firstName, String middleName) {
		
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
	}
}
