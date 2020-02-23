package education;

import java.time.LocalDate;

public abstract class Education {
	private boolean graduated;
	private LocalDate enrollmentDate;
	private LocalDate graduationDate;
	private String institutionName;

	protected Education(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName) {
		this.enrollmentDate = enrollmentDate;
		this.graduationDate = graduationDate;
		this.institutionName = institutionName;
		if (LocalDate.now().isAfter(graduationDate)) {
			this.graduated = true;
		}
	}
	
	protected abstract String getDegree();
	
	protected abstract boolean gotGraduated();
	
	protected boolean isGraduated() {
		if(this.graduated) {
			return true;
		}
		return false;
	}
	
	protected LocalDate getEnrollmentData() {
		return this.enrollmentDate;
	}
	
	protected LocalDate getGraduationDate() {
		return this.graduationDate;
	}
	
	protected String getInstutionName() {
		return this.institutionName;
	}	
}
