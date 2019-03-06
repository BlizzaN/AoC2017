package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Day4 {

	public static void main(String[] args) throws IOException {

		// passphrases();
		anagrams();
	}

	private static void anagrams() throws FileNotFoundException {

		File file = new File("");
		Scanner sc = new Scanner(file);
		String[] words;
		String line = "";
		int count = 0;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			//Remove all white space
			words = line.trim().split("\\s+");

			Set<String> set = new HashSet<String>();
			for (String str : words) {
				//{1,5,2,3,9,6}
				//Create char array for the word
				char[] ca = str.toCharArray();
				
				//{1,2,3,5,6,9}
				//Sort char array 
				Arrays.sort(ca);
				
				//Create string for the sorted char array
				String w = new String(ca);
				
				//Check if word contains in the set
				if ((set.contains(w))) {
					count--;
					System.out.println("Invalid");
					break;
				} else {
					set.add(w);
				}
			}
			count++;
		}
		System.out.println("Count: " + count);
		sc.close();
	}

	private static void passphrases() throws IOException {

		File file = new File("");
		Scanner sc = new Scanner(file);
		String[] words;
		String line = "";
		int count = 0;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			words = line.trim().split("\\s+");

			HashSet<String> set = new HashSet<String>();
			for (String str : words) {
				if ((set.contains(str))) {
					count--;
					System.out.println("Invalid");
					break;
				} else {
					set.add(str);
				}
			}
			count++;

		}
		System.out.println("Count: " + count);
		sc.close();

	}

}
