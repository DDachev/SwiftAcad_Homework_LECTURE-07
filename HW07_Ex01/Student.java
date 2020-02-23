package bg.swift.HW07_Ex01;

public class Student extends Person {
private String facultyNumber;
private int lectureCount;
private int exerciseCount;

	public Student(String firstName, String lastName, String facultyNumber, double lectureCount, double exerciseCount) {
		super(firstName, lastName);
		if(isValidAll(facultyNumber, lectureCount, exerciseCount)) {
			this.facultyNumber = facultyNumber;
			this.lectureCount = (int)lectureCount;
			this.exerciseCount = (int)exerciseCount;
			super.occupation = "Student";
			super.enrollmentHours = ((this.lectureCount * 2) + (this.exerciseCount * 1.5))/5;
		}
	}
	
	protected static boolean isValidAll(String facultyNumber, double count, double count2) {
		if(isValidFacultyNumber(facultyNumber) && isValidLecExCount(count) && isValidLecExCount(count2)) {
			return true;
		}
		return false;
	}

	private static boolean isValidFacultyNumber(String facultyNumber) {
		if (facultyNumber.length() >= 5 && facultyNumber.length() <= 10 && !facultyNumber.trim().isEmpty()) {
			return true;
		}
		System.out.println("Expected length for faculty number is between 5 and 10 symbols.");
		return false;
	}

	private static boolean isValidLecExCount(double count) {
		int temp = (int) count;
		if (count > 0) {
			if (temp != count) {
				System.out.println("Expected integer for <parameter>.");
				return false;
			}
			return true;
		}
		System.out.println("Expected positive number for <parameter>.");
		return false;
	}

	@Override
	void printInfo() {
		super.printInfo();
		System.out.printf("%s%nFaculty number: %s%nHours per day: %.2f", super.occupation, this.facultyNumber, super.enrollmentHours);
		System.out.println();
	}
}
	

