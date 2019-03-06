package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import javax.print.attribute.HashAttributeSet;

public class Day6 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		memoryBank();
	}
	
	private static void memoryBank() throws FileNotFoundException{
		ArrayList<Integer> numbers = new ArrayList<>();
		File file = new File("");
		Scanner sc = new Scanner(file);
		int input = 0;
		while (sc.hasNextInt()) {
			input = sc.nextInt();
			numbers.add(input);
			
		}
		sc.close();
		
		//First
		boolean go = true;
		int temp = 0;
		int max = 0;
		int indexAtMax = 0;
		int count = 0;
		String found = "";
		HashSet<String> set = new HashSet<>();
		
		set.add(numbers.toString());
		while(go){
			for(int i = 0; i < numbers.size(); i++){
				temp = numbers.get(i);
				if(temp > max){
					max = temp;
					indexAtMax = i;
				}
			}
			
			numbers.set(indexAtMax, 0);
			for(int i = 1; 0 < max; max--){

				numbers.set((indexAtMax+i)%numbers.size(), numbers.get((indexAtMax+i)%numbers.size())+1);
				i++;
				
			}

			if(!(set.contains(numbers.toString()))){
				System.out.println(numbers);
				set.add(numbers.toString());
				count++;
			}else{
				go = false;
				count=0;
				found = numbers.toString();
				
			}
	
		}
		
		//Second
		
		
		go = true;
		while(go){
			for(int i = 0; i < numbers.size(); i++){
				temp = numbers.get(i);
				if(temp > max){
					max = temp;
					indexAtMax = i;
				}
			}
			
			numbers.set(indexAtMax, 0);
			for(int i = 1; 0 < max; max--){

				numbers.set((indexAtMax+i)%numbers.size(), numbers.get((indexAtMax+i)%numbers.size())+1);
				i++;
				
			}
			count++;
			if(found.equals(numbers.toString())){
				System.out.println("Yeeeey");
				go = false;
			}

		}
		
		System.out.println("Count: " + count);
		
	}

}
