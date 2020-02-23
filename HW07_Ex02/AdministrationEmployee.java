package bg.swift.HW07_Ex02;

public class AdministrationEmployee extends Employee {
	private String[] leadSubjects;

	protected AdministrationEmployee(String name, String phoneNumber, String... arg) {
		super(name, phoneNumber);
		salaryPerHour = 19;
		this.leadSubjects = arg;
	}
}
