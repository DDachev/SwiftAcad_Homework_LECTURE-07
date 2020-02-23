package bg.swift.HW07_Ex02;

public class Employee extends Person {
	protected int salaryPerHour;

	protected Employee(String name, String phoneNumber) {
		super(name, phoneNumber);
	}

	@Override
	protected void work() {
		universityBalance -= salaryPerHour;
	}
}
