package phase01;

public class AdvanceFormat extends BasicFormat{
	
	/************************** Attribute ************************/
	public static int lengthText = 0; // Total characters
	public static int wordCount = 0; // Total words
	
	// Constructor with parameter
	public AdvanceFormat(String input) {
		super(input);
	}
	
	/************************** METHOD **************************/
	// Break lines text
	public String[] breakLines(String str) {
		return null;
	}
	
	// Sort text after break lines
	public String[] sortText(String[] str) {
		return null;
	}
	
	// Advance format text after sort text
	public String[] caseF(String[] str) {
		return null;
	}
	
	// Add line number for each line after sort
	public String[] addLine(String[] str) {
		return null;
	}

	// Count Words
	public static int countWords(char c) {
		return wordCount++;
	}
}
