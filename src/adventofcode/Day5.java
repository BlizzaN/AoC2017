package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5 {


	public static void main(String[] args) throws FileNotFoundException {

		jumpArray();
	}

	private static void jumpArray() throws FileNotFoundException {

		ArrayList<Integer> numbers = new ArrayList<>();
		File file = new File("");
		Scanner sc = new Scanner(file);
		int input = 0;
		while (sc.hasNextInt()) {
			input = sc.nextInt();
			numbers.add(input);
			
		}
		sc.close();
		
		int count = 0;
		int index = 0;
		int value = 0;
		
		
		boolean go = true;
		while(index < numbers.size()){
		
			numbers.get(index);
			
			
			value = numbers.get(index);
			
			int temp = index;
			if(value >= 3){
				numbers.set(temp, value-1);
			}else{
				numbers.set(temp, value+1);
			}
			index += value;
			
			count++;

		}
		System.out.println("Count: " + count);
		
		
		
	}

}
