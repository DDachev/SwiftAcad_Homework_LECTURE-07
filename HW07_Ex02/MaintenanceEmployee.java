package bg.swift.HW07_Ex02;

public class MaintenanceEmployee extends Employee {

	protected MaintenanceEmployee(String name, String phoneNumber) {
		super(name, phoneNumber);
		super.salaryPerHour = 15;
	}
}
