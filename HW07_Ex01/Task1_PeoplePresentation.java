package bg.swift.HW07_Ex01;

import java.util.Scanner;

public class Task1_PeoplePresentation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("You have to insert information for the person: ");
		String line = sc.nextLine();

		while (!"END".equals(line)) {
			String[] personInfo = line.split(" ");

			if (!Person.isValidName(personInfo[0]) || !Person.isValidName(personInfo[1])) {
				break;
			}

			if (personInfo.length == 4) {
				if (!Worker.isValidAll(Double.parseDouble(personInfo[2]), Double.parseDouble(personInfo[3]))) {
					break;
				}
				Person worker = new Worker(personInfo[0], personInfo[1], Double.parseDouble(personInfo[2]),
						Double.parseDouble(personInfo[3]));
				worker.printInfo();
			}
			if (personInfo.length == 5) {
				if (!Student.isValidAll(personInfo[2], Double.parseDouble(personInfo[3]),
						Double.parseDouble(personInfo[4]))) {
					break;
				}
				Person student = new Student(personInfo[0], personInfo[1], personInfo[2],
						Double.parseDouble(personInfo[3]), Double.parseDouble(personInfo[4]));
				student.printInfo();
			}

			line = sc.nextLine();
		}
		sc.close();
	}
}
