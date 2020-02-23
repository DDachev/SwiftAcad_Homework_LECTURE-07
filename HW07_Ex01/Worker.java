package bg.swift.HW07_Ex01;

public class Worker extends Person {
	private double weekSalary;
	private double workHoursPerDay;

	public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
		super(firstName, lastName);
		if (isValidAll(weekSalary, workHoursPerDay)) {
			this.weekSalary = weekSalary;
			this.workHoursPerDay = workHoursPerDay;
			super.occupation = "Worker";
			super.enrollmentHours = workHoursPerDay;
		}
	}

	public static boolean isValidAll(double parameter1, double parameter2) {
		if(isValidParameter(parameter1) && isValidParameter(parameter2)) {
			return true;
		}
		return false;
	}
	
	private static boolean isValidParameter(double parameter) {
		if (parameter > 0) {
			return true;
		}
		System.out.println("Expected positive number for <parameter>.");
		return false;
	}

	@Override
	void printInfo() {
		super.printInfo();
		System.out.printf("%s%nWeek salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f", super.occupation,
				this.weekSalary, this.workHoursPerDay, (this.weekSalary / (5 * this.workHoursPerDay)));
		System.out.println();
	}
}
