package bg.swift.HW07_Ex02;

public class Teacher extends Employee {
	private String[] teachSubjects;

	protected Teacher(String name, String phoneNumber, String... arg) {
		super(name, phoneNumber);
		super.salaryPerHour = 25;
		this.teachSubjects = arg;
	}
}
