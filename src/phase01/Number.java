package phase01;

import java.util.ArrayList;
import java.util.Scanner;

public class Number extends PlainText {
	/************************** Attribute ************************/	
	// Get Number List from Plain Text
	public int[] getArrayNumber(String str) {
		str = str.replaceAll("[^0-9]+", " ");
		Scanner scanner = new Scanner(str);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
			list.add(scanner.nextInt());
		}
		int[] result = new int[list.size()];
		for (int i=0; i<list.size(); i++) {
			result[i] = list.get(i);
		}
		scanner.close();
		return result;
	}
	
	// Print array of Number
	public String printArrayNumber(int[] arrayNumber) {
		String str = "";
		for(int i=0; i < arrayNumber.length; i++) {
			str+= arrayNumber[i] + ", ";
		}
		StringBuilder result = new StringBuilder(str);
		result.delete(str.length()-2, str.length()-1);
		return result.toString();
	}
}


