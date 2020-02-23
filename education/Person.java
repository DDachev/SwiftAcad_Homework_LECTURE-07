package education;

import java.time.LocalDate;

public class Person {

	private String firstName;
	private String lastName;
	private char gender;
	private LocalDate dateOfBirth;
	private short height;
	private char codeOfEducation;
	protected Education ed;

	protected Person(String firstName, String lastName, char gender, LocalDate dateOfBirth, char codeOfEducation,
			short height, LocalDate enrollmentDate, LocalDate graduationDate, String institutionName,
			double finalGrade) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.codeOfEducation = codeOfEducation;
		this.height = height;
		if (this.codeOfEducation == 'P') {
			this.ed = new PrimaryEducation(enrollmentDate, graduationDate, institutionName);
		} else if (this.codeOfEducation == 'S') {
			this.ed = new SecondaryEducation(enrollmentDate, graduationDate, institutionName, finalGrade);
		} else if (this.codeOfEducation == 'B' || this.codeOfEducation == 'M' || this.codeOfEducation == 'D') {
			this.ed = new HigherEducation(enrollmentDate, graduationDate, institutionName, finalGrade);
		}
	}

	public boolean isUnderAge(LocalDate dateOfBirth) {
		LocalDate dateNow = LocalDate.now();
		if (dateNow.minusYears(18).compareTo(dateOfBirth) >= 0) {
			return true;
		}
		return false;
	}
	
	public int getAgeOfPerson() {
		LocalDate dateNow = LocalDate.now();
		int ageOfPerson = dateNow.compareTo(this.dateOfBirth);
		boolean yearIsAfter = this.dateOfBirth.plusYears(dateNow.getYear() - this.dateOfBirth.getYear())
				.isAfter(dateNow);

		if (yearIsAfter) {
			return ageOfPerson - 1;
		}
		return ageOfPerson;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public char getGender() {
		return gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public short getHeight() {
		return height;
	}
	
	public char getCodeOfEducation() {
		return this.codeOfEducation;
	}
	
	public String getDegree() {
		char code = getCodeOfEducation();
		if(code == 'P') {
			return "primary";
		} else if(code == 'S') {
			return "secondary";
		} else if (code == 'B') {
			return "bachelor";
		} else if (code == 'M') {
			return "master";
		} else if(code == 'D') {
			return "doctorate";
		}
		return null;
		
	}
}
