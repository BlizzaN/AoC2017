package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day23 {

	public static void main(String[] args) throws FileNotFoundException {
		coprocessor();

	}

	private static void coprocessor() throws FileNotFoundException {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;
		int g = 0;
		int h = 0;

		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("a", a);
		m.put("b", b);
		m.put("c", c);
		m.put("d", d);
		m.put("e", e);
		m.put("f", f);
		m.put("g", g);
		m.put("h", h);

		ArrayList<String> contentOfTxtFile = new ArrayList<>();
		File file = new File("");
		;
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			contentOfTxtFile.add(sc.nextLine());
		}
		sc.close();

		String code = null;
		String register = null;
		String value = null;
		int countMul = 0;

		// for (String str : contentOfTxtFile) {
		for (int i = 0; i < contentOfTxtFile.size(); i++) {
			code = contentOfTxtFile.get(i).substring(0, 3);
			register = contentOfTxtFile.get(i).substring(4, 5);
			System.out.println("reg: " + register);
			value = contentOfTxtFile.get(i).substring(6);
			System.out.println("value: " + value);

			switch (code) {
			case "set":
				if (value.matches(".*\\d+.*") == true) {
					int tempInt = Integer.parseInt(value);
					System.out.println("tempInt: " + tempInt);
					m.put(register, tempInt);

				} else {
					int tempValue = m.get(value);
					System.out.println("temp: " + tempValue);
					m.put(register, tempValue);
				}

				break;
			case "sub":
				if (value.matches(".*\\d+.*") == true) {
					int tempInt = Integer.parseInt(value);
					int valueFromRegister = m.get(register);
					valueFromRegister -= tempInt;

					m.put(register, valueFromRegister);

				} else {
					int tempValue = m.get(value);
					int valueFromRegister = m.get(register);
					valueFromRegister -= tempValue;

					m.put(register, valueFromRegister);
				}
				break;
			case "mul":
				countMul++;
				if (value.matches(".*\\d+.*") == true) {
					int tempInt = Integer.parseInt(value);
					int valueFromRegister = m.get(register);
					valueFromRegister *= tempInt;

					m.put(register, valueFromRegister);
				} else {
					int tempValue = m.get(value);
					int valueFromRegister = m.get(register);
					valueFromRegister *= tempValue;

					m.put(register, valueFromRegister);
				}
				break;
			case "jnz":

				int offset = Integer.parseInt(value);

				int valueFromRegister;
				if (!(m.get(register) + "").matches("^-?\\d+$")) {
					valueFromRegister = Integer.parseInt(register);
				} else {
					valueFromRegister = m.get(register);
				}

				if (valueFromRegister == 0) {
					break;
				} else {
					i--;
					i += offset;
				}

				break;
			default:
				break;
			}

		}

		System.out.println("countMul: " + countMul);

	}
}
