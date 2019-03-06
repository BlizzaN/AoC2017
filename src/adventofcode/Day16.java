package adventofcode;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Day16 {

	static HashSet<String> cycle = new HashSet<>();
	
	static LinkedList<String> list = new LinkedList();

	
	static int count = 0;
	public static void main(String[] args) throws FileNotFoundException {

		
			promenade();
		
	}
	private static void promenade() throws FileNotFoundException {
		
		String[] program = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
		"p" };
		
		for(int it = 0; it < 1000000000 % 48; it++){

		File file = new File("");
		Scanner sc = new Scanner(file);
		String[] input = null;
		while (sc.hasNextLine()) {
			input = sc.nextLine().split(",");

		}
		sc.close();
		
		

		for (String word : input) {

			char[] c = word.toCharArray();
			for (char ch : c) {

				switch (ch) {
				case 'x':
					word = word.substring(1);

					String[] parts = word.split("/");
					int first = Integer.parseInt(parts[0]);
					int second = Integer.parseInt(parts[1]);

					String temp = program[first];
					program[first] = program[second];

					program[second] = temp;

					break;
				case 'p':
					int firstWithP;
					int secondWithP;

					word = word.substring(1);

					String[] partsWithP = word.split("/");
					if (partsWithP[0].isEmpty()) {
						break;
					}

					if (partsWithP[0].matches("[0-9]") == true) {
						firstWithP = Integer.parseInt(partsWithP[0]);
					} else {
						firstWithP = Arrays.asList(program).indexOf(partsWithP[0]);

					}

					if (partsWithP[1].matches("[0-9]") == true) {
						secondWithP = Integer.parseInt(partsWithP[1]);
					} else {
						secondWithP = Arrays.asList(program).indexOf(partsWithP[1]);
					}

					String tempWithP = program[firstWithP];
					program[firstWithP] = program[secondWithP];
					program[secondWithP] = tempWithP;

					break;
				case 's':
					word = word.substring(1);

					int shift = Integer.parseInt(word);

					String swap = Shiftright(program, shift);
					String tempvar = "";
					for (int i = 0; i < program.length - shift; i++) {
						tempvar += program[i];
					}
					String tempSwap = swap;

					swap = tempvar;

					tempvar = tempSwap;
					String value = tempvar.concat(swap);

					for (int i = 0; i < program.length; i++) {
						program[i] = value.substring(i, i + 1);

					}

					break;
				default:
					break;
				}

			}

		}

		// System.out.println("DONE");
		for (int i = 0; i < program.length; i++) {
			// System.out.print(program[i]);
			 list.add(program[i]);
			 
		}
		
		
		System.out.println(list.toString() + " " + count);
		
		
		if(cycle.contains(list.toString())){
	
			System.out.println("CYCLE " + count);
			break;
		}else{

			cycle.add(list.toString());
		}
		count++;
		list.clear();

		}
		
		for(int pro = 0; pro < program.length; pro++){
			System.out.print(program[pro]);
		}
	}

	private static String Shiftright(String[] program, int shift) {

		String temp = Arrays.toString(program);
		temp = temp.replace("]", "");
		temp = temp.replace("[", "");
		temp = temp.replace(",", "");
		temp = temp.replace(" ", "");

		return temp.substring(temp.length() - shift);

	}

}
