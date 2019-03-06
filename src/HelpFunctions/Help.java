package HelpFunctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Help {
	
	
	public int readNumbers() throws FileNotFoundException{
		File file = new File("C:/Users/Pontus/Desktop/Java/adventofcode/src/HelpFunctions/Numbers.txt");
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()){
			System.out.println("number: " + sc.nextLine());
		}
		
		
		
		return 0;
		
		
		
	}

	// Read text from a text file
	public String readFromFile() throws IOException {
		String stringIsDone = "";
		BufferedReader br = new BufferedReader(
				new FileReader("C:/Users/Pontus/Desktop/Java/adventofcode/src/HelpFunctions/Numbers.txt"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}

			stringIsDone = sb.toString();

		} finally {
			br.close();
		}

		return stringIsDone;
	}

}
