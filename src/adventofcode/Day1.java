package adventofcode;

import java.util.ArrayList;

public class Day1 {

	private static int sum = 0;
	public static void main(String[] args) {
	
		checkSequence("1212");
	}
	
	//Part two
	private static void checkSequence(String str){
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == str.charAt((i+str.length()/2)%str.length())){
				
				sum += (int)str.charAt(i) - 48;
			}	
		}

		System.out.println("Sum: " + sum);
		
	}

}
