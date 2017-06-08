package phase01;

public class Formatting {

	/************************** Attribute ************************/
	private String input; // Raw text from user input
	
	// Constructor with parameter
	protected Formatting(String input) {
		this.input = input;
	}
	
	// Constructor default
	protected Formatting() {
		this.input = "";
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
	// Get Number List from raw text
	protected String getNumberList(String str) {
		return str;
	}
	
	// Remove HTML tag from raw text
	protected String removeHTML(String str) {
		return "";
	}
	
	// Re-Format text after remove HTML tag 
	protected String reformatText(String str) {
		return "";
	}
	
}
