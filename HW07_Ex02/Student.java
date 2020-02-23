package bg.swift.HW07_Ex02;

public class Student extends Person {
	private String facultyNumber;
	private String[] subjects;

	protected Student(String name, String phoneNumber, String facultyNumber, String...arg) {
		super(name, phoneNumber);
		this.facultyNumber = facultyNumber;
		this.subjects = arg;
	}
	
	@Override
	protected void work() {
		if(super.getTolerance() >= 50) {
			universityBalance += 10;
		}
	}

}
