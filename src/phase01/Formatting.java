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
	// Remove HTML tag from raw text
	protected String removeHTML(String str) {
		return str.replaceAll("\\<.*?>","");
	}
	
	// Re-Format text after remove HTML tag 
	protected String reformatText(String str) {
		// Remove HTML tag
		str = this.removeHTML(str);
		
		// Remove extra space
		str = str.replaceAll("\\s{2,}", " ").trim();
		
		// Upper case letter after period
		StringBuilder temp = new StringBuilder(str.length());
        // First one is capital!
        boolean capitalize = true;

        // Go through all the characters in the sentence.
        for(int i = 0; i < str.length(); i++) {
            // Get current char
            char c = str.charAt(i);

            // If it's period then set next one to capital
            if(c == '.') {
                capitalize = true;
            }
            // If it's alphabetic character...
            else if(capitalize && Character.isAlphabetic(c)) {
                // Turn it to uppercase
                c = Character.toUpperCase(c);
                // Don't capitalize next characters
                capitalize = false;
            }

            // Accumulate in result
            temp.append(c);
        }
        str = temp.toString();
        
        // Add a spacing after punctuation
        str = str.replaceAll("[,.!?;:]", "$0 ");
        
        // Remove a spacing before punctuation (. , : ?)
        str = str.replace(" .", ".");
        str = str.replace(" ,", ",");
        str = str.replace(" :", ":");
        return str.replace(" ?", "?");
	}
	
	// Advance format text after re-format text
	protected String advanceFormatText(String str) {
		return null;
	}
		
	
}
