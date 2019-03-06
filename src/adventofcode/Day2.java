package adventofcode;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import HelpFunctions.Help;

public class Day2 {

	public static void main(String[] args) throws IOException {

		// readTextAndCalculateDiffAndSum();
		readTextAndCalculateDivideSum();

	}

	// Part one
	private static void readTextAndCalculateDiffAndSum() throws IOException {

		int min = Integer.MAX_VALUE;
		int max = 0;
		int input = 0;
		int sum = 0;

		File file = new File("");
		Scanner sc = new Scanner(file);
		String[] numbers;
		String line = "";
		while (sc.hasNextLine()) {

			line = sc.nextLine();
			numbers = line.trim().split("\\s+");

			for (int i = 0; i < numbers.length; i++) {
				input = Integer.parseInt(numbers[i]);
				if (input > max) {
					max = input;
				}
				if (input < min) {
					min = input;
				}

			}
			System.out.println("Diff: " + (max - min));
			sum += (max - min);

			max = 0;
			min = Integer.MAX_VALUE;

		}
		sc.close();
		System.out.println("Sum: " + sum);

	}

	private static void readTextAndCalculateDivideSum() throws IOException {

		int sum = 0;
		

		File file = new File("");
		Scanner sc = new Scanner(file);
		String[] numbers;
		String line = "";
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			numbers = line.trim().split("\\s+");
			for (int i = 0; i < numbers.length; i++) {
				for (int j = 0; j < numbers.length; j++) {
					if (i == j)
						continue;
					if ((Integer.parseInt(numbers[i]) % Integer.parseInt(numbers[j])) == 0) {
						System.out.println("Number: " + (Integer.parseInt(numbers[i]) / Integer.parseInt(numbers[j])));
						
						sum += Integer.parseInt(numbers[i]) / Integer.parseInt(numbers[j]);
					}
				}

			}
			

		}
		System.out.println("Sum: " + sum);

		sc.close();

	}

}
