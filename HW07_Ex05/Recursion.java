package bg.swift.HW07_Ex05;

public class Recursion {

	public static void main(String[] args) {
		System.out.println(numberOfDegree(2, 10));
	}

	private static int numberOfDegree(int number, int degree) {
		if (degree == 1) {
			return number;
		}
		return number * numberOfDegree(number, (degree - 1));
	}
}
