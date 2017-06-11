package phase01;

import java.util.ArrayList;
import java.util.Scanner;

public class TextUtilities extends Formatting{
	
	/************************** Attribute ************************/
	public static int lengthText = 0; // Total characters
	public int wordCount = 0; // Total words
	
	// Constructor with parameter
	public TextUtilities(String input) {
		super(input);
	}
	
	// Constructor default
	public TextUtilities() {
		super();
	}
	
	/************************** METHOD **************************/
	// Break lines text after re-format
	public String[] breakLines(String str) {	
		str = this.reformatText(str);
		String[] arr = str.split("(?<=[.])");
		return arr;
	}
	
	// Sort text after break lines
	public String sortText(String str) {
		return null;
	}
	
	// Add line number for each line after sort text
	public String addLine(String str) {
		return null;
	}

	// Count Words from input text
	public int countWords(String str) {
		// Remove extra space
		str = str.replaceAll("\\s{2,}", " ").trim();

		if(str.charAt(0) != ' ') {
			wordCount = 1;
			wordCount+= str.length() - str.replaceAll(" ", "").length();
		}
		return wordCount;
	}
	
	// Get Number List from raw text
	public int[] getNumberList(String str) {
		str = str.replaceAll("[^0-9]+", " ");
		Scanner scanner = new Scanner(str);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (scanner.hasNextInt()) {
		    list.add(scanner.nextInt());
		}
		scanner.close();
		int[] result = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}
	// Print array int
	public String printArrayInt(int[] arr) {
		String result = "";
		for(int i:arr) {
			result+= arr[i] + ", ";
		}
		return result;
	}
	//Print array String
	public String printArrayString(String[] arr){
		String result = "";
		for(String a:arr) {
			result+= a + "\n";
		}
		return result;
	}
}
