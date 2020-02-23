package bg.swift.HW07_Ex02;

import java.util.Scanner;

public class Task2_UniversityManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person[] people = new Person[500];
		int countOfPeople = 0;
		boolean hasTolerance = true;
		boolean hasUniversityBalance = true;
		System.out.println("You have to insert information for the person: ");
		String line = sc.nextLine();

		while (!"END".equals(line) && hasTolerance && hasUniversityBalance) {
			String[] command = line.split(" ");

			if (command[0].equals("NEW")) {
				if (command[1].equals("MAINT")) {
					people[countOfPeople] = new MaintenanceEmployee(command[2], command[3]);
					countOfPeople++;
				}
				if (command[1].equals("ADMIN")) {
					people[countOfPeople] = new AdministrationEmployee(command[2], command[3], command[4]);
					countOfPeople++;
				}
				if (command[1].equals("TEACH")) {
					people[countOfPeople] = new Teacher(command[2], command[3], command[4]);
					countOfPeople++;
				}
				if (command[1].equals("STUD")) {
					people[countOfPeople] = new Student(command[2], command[3], command[4], command[5]);
					countOfPeople++;
				}
			}

			if (command[0].equals("WORK")) {
				for (int i = 0; i < countOfPeople; i++) {
					if (command[1].equals(people[i].getName())) {
						if (people[i] instanceof MaintenanceEmployee) {
							people[i].work();
							if (!people[i].checkUniversityBalance()) {
								hasUniversityBalance = false;
								break;
							}
							for (int j = 0; j < countOfPeople; j++) {
								people[j].increaseTolerance(2);
								continue;
							}
						}

						if (people[i] instanceof AdministrationEmployee) {
							people[i].work();
							if (!people[i].checkUniversityBalance()) {
								hasUniversityBalance = false;
								break;
							}
							for (int j = 0; j < countOfPeople; j++) {
								if (people[j] instanceof MaintenanceEmployee) {
									people[j].increaseTolerance(1);
									continue;
								}
								if (people[j] instanceof Student) {
									people[j].increaseTolerance(3);
									continue;
								}
								if (people[j] instanceof Teacher) {
									people[j].increaseTolerance(3);
									continue;
								}
							}
						}

						if (people[i] instanceof Teacher) {
							people[i].work();
							if (!people[i].checkUniversityBalance()) {
								hasUniversityBalance = false;
								break;
							}
							for (int j = 0; j < countOfPeople; j++) {
								if (people[j] instanceof Student) {
									people[j].increaseTolerance(3);
									continue;
								}
								if (people[j] instanceof MaintenanceEmployee) {
									people[j].reduceTolerance(3);
									if (!people[j].checkTolerance()) {
										hasTolerance = false;
										break;
									}
									continue;
								}
								if (people[j] instanceof AdministrationEmployee) {
									people[j].reduceTolerance(1);
									if (!people[j].checkTolerance()) {
										hasTolerance = false;
										break;
									}
									continue;
								}
							}
						}

						if (people[i] instanceof Student) {
							people[i].work();
							if (!people[i].checkUniversityBalance()) {
								hasUniversityBalance = false;
								break;
							}
							for (int j = 0; j < countOfPeople; j++) {
								if (people[j] instanceof Student) {
									people[j].increaseTolerance(2);
									continue;
								}
								if (people[j] instanceof MaintenanceEmployee) {
									people[j].reduceTolerance(1);
									if (!people[j].checkTolerance()) {
										hasTolerance = false;
										break;
									}
									continue;
								}
							}
						}
					}
				}
			}

			if (command[0].equals("IDLE")) {
				for (int i = 0; i < countOfPeople; i++) {
					people[i].notWorking();
					if (!people[i].checkTolerance()) {
						hasTolerance = false;
						break;
					}
				}
			}
			line = sc.nextLine();
			if (line.equals("END")) {
				for (int i = 0; i < countOfPeople; i++) {
					people[i].printInfo();
				}
				System.out.println("This is the university's balance: " + Person.universityBalance);
				break;
			}
		}
		sc.close();
	}
}
