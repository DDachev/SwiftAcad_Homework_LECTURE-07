package bg.swift.HW07_Ex01;

public class Person {
	protected String firstName;
	protected String lastName;
	protected String occupation;
	protected double enrollmentHours;
	
	public Person(String firstName, String lastName) {
		if(isValidName(firstName) && isValidName(lastName)) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
	}
	
	protected static boolean isValidName(String name) {
		if (name.length() < 2 || name.length() > 30) {
			System.out.println("Expected length for <parameter> is between 2 and 30 symbols.");
			return false;
		}
		if (name.charAt(0) >= 65 && name.charAt(0) <= 90) {
			for (int i = 0; i < name.length(); i++) {
				if (name.charAt(i) < 65 || (name.charAt(i) > 90 && name.charAt(i) < 97) || name.charAt(i) > 122) {
					System.out.println("Expected only Latin letters in <parameter>.");
					return false;
				}
			}
			return true;
		}
		System.out.println("Expected upper case letter at first position of <parameter>.");
		return false;
	}	
	
	void printInfo() {
		System.out.printf("First name: %s%nLast name: %s%nOccupation: ", this.firstName, this.lastName);
	}
	
}
