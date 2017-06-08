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
		return str;
	}
	
	// Re-Format text after remove HTML tag 
	protected String reformatText(String str) {
		String result = str.replaceAll("\\s{2,}", " ").trim();
		StringBuilder temp = new StringBuilder(result.length());
        //First one is capital!
        boolean capitalize = true;

        //Go through all the characters in the sentence.
        for(int i = 0; i < result.length(); i++) {
            //Get current char
            char c = result.charAt(i);

            //If it's period then set next one to capital
            if(c == '.') {
                capitalize = true;
            }
            //If it's alphabetic character...
            else if(capitalize && Character.isAlphabetic(c)) {
                //...we turn it to uppercase
                c = Character.toUpperCase(c);
                //Don't capitalize next characters
                capitalize = false;
            }

            //Accumulate in result
            temp.append(c);
        }
        result = temp.toString();
        result = result.replaceAll("[,.!?;:]", "$0 ").replaceAll("\\s+", " ");
        return result.replaceAll("\\s+(?=\\p{Punct})", "");
	}
	
	// Advance format text after re-format text
	protected String advanceFormatText(String str) {
		return null;
	}
		
	
}
