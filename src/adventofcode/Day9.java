package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.Scanner;

public class Day9 {

	public static void main(String[] args) throws FileNotFoundException {
		readCharacters();

	}

	private static void readCharacters() throws FileNotFoundException {

		ArrayList<String> str = new ArrayList<>();
		File file = new File("");
		Scanner sc = new Scanner(file);
		String input = "";

		int garbageCount = 0;

		while (sc.hasNextLine()) {
			input = sc.next();
			if (sc.hasNextLine()) {
				garbageCount++;
			}
			str.add(input);

		}
		sc.close();

		int count = 0;
		int total = 0;

		boolean skip = false;
		boolean garbage = false;

		for (String value : str) {

			for (char c : value.toCharArray()) {

				if (skip) {
					skip = false;
					continue;
				}

				switch (c) {
				case '{':
					if (!garbage) {
						count++;
					} else {
						garbageCount++;

					}
					break;
				case '}':
					if (!garbage) {
						total += count;
						count--;
					} else {
						garbageCount++;
					}
					break;
				case '!':
					skip = true;
					break;
				case '<':
					if (garbage) {
						garbageCount++;
					}
					garbage = true;

					break;
				case '>':
					garbage = false;
					break;
				default:
					if(garbage){
						garbageCount++;

					}
					break;
				}
			}

		}

		System.out.println(total + " " + garbageCount);

	}

}
