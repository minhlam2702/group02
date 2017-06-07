package phase01;

public class BasicFormat {

	/************************** Attribute ************************/
	private String input; // Input from user
	public static int lengthText = 0; // Total characters
	public static int wordCount = 0; // Total words

	
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
	public static int countCharacter(char c) {
		return lengthText++;
	}
	
	// Count Words
	public static int countWords(char c) {
		return wordCount++;
		
		
	}
}
