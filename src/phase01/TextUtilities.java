package phase01;

public class TextUtilities extends Formatting{
	
	/************************** Attribute ************************/
	public static int lengthText = 0; // Total characters
	public static int wordCount = 0; // Total words
	
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
	public String breakLines(String str) {
		return null;
	}
	
	// Sort text after break lines
	public String sortText(String str) {
		return null;
	}
	
	// Advance format text after re-format text
	public String getAdvanceFormat(String str) {
		return null;
	}
	
	// Add line number for each line after sort text
	public String addLine(String str) {
		return null;
	}

	// Count Words from input text
	public static int countWords(char c) {
		return wordCount++;
	}
}
