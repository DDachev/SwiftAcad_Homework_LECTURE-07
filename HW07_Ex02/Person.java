package bg.swift.HW07_Ex02;

public class Person {
	private String name;
	private String phoneNumber;
	private int tolerance;
	protected static int universityBalance = 500;

	protected Person(String name, String phoneNumber) {
		if (isValidName(name) && isValidPhoneNumber(phoneNumber)) {
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.tolerance = 20;
		}
	}

	private static boolean isValidName(String name) {
		if (name != null && !name.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	private static boolean isValidPhoneNumber(String phoneNumber) {
		if (!phoneNumber.trim().isEmpty() && phoneNumber.length() >= 5) {
			return true;
		}
		return false;
	}
	
 	protected void notWorking() {
		this.tolerance -= 5;
	}
	
	protected void work() {
		
	}
	
	protected boolean checkTolerance() {
		if(this.tolerance <= 0) {
			System.out.println(this.name + " is not happy");
			return false;
		}
		return true;
	}
	
	protected boolean checkUniversityBalance() {
		if(getUniversityBalance() <= 0) {
			System.out.println("Bankrupcy");
			return false;
		}
		return true;
	}
	
	protected void increaseTolerance(int value) {
		this.tolerance += value;
	}
	
	protected void reduceTolerance(int value) {
		this.tolerance -= value;
	}
	
	protected void printInfo() {
		System.out.println(this.name + " " + getTolerance());
	}
	
	protected String getName() {
		return this.name;
	}
	
	protected int getTolerance() {
		return this.tolerance;
	}
	
	protected int getUniversityBalance() {
		return Person.universityBalance;
	}
	
}
