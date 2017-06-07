package phase01;

public class BasicFormat {

	/************************** Attribute ************************/
	private String input; // Input from user
	private static int lengthText = 0; // Total characters
	private static int wordCount = 0; // Total words

	
	// Constructor with parameter
	protected BasicFormat(String input) {
		this.input = input;
	}
	
	// Get input
	protected String getInput() {
		return input;
	}
	
	// Set input
	protected void setInput(String input) {
		this.input = input;
	}
	
	/************************** METHOD ****************************/
	// Get Number List
	protected String getNumberList(String str) {
		return "";
	}
	
	// Remove HTML tag
	protected String removeHTML(String str) {
		return "";
	}
	
	// Re-Format String Basic
	protected String reformatText(String str) {
		return "";
	}
	
	// Count Character
	protected static int countCharacter() {
		return lengthText++;
	}
	
	// Count Words
	protected static int countWords(char c) {
		return wordCount++;
		
		
	}
}
