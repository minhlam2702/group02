package phase01;

public class PlainText {

	/************************** Attribute ************************/
	private int numberOfWords; // Total words
	
	// Constructor with parameter
	protected PlainText(String value) {
		this.numberOfWords = this.countWords(value);
	}
	
	// Constructor default
	protected PlainText() {
		this.numberOfWords = 0;
	}
	
	/************************** METHOD ****************************/
	/** Count words from plain text **/
	protected int countWords(String str) {
		if(str != null && str != "") {
			// Remove extra space
			str = this.removeExtraSpace(str);

			if(str.charAt(0) != ' ') {
				numberOfWords = 1;
				numberOfWords+= str.length() - str.replaceAll(" ", "").length();
			} else {
				numberOfWords = 0;
			}
			return numberOfWords;
		} else {
			numberOfWords = 0;
			return numberOfWords;
		}
		
	}
	
	/** Remove HTML tag from plain text **/
	protected String removeHTML(String str) {
		return str.replaceAll("\\<.*?>","");
	}
	
	/** Remove extra spacing from plain text **/
	protected String removeExtraSpace(String str) {
		// Remove extra spacing 
		return str.replaceAll("\\s{2,}", " ").trim();
	}
	
	/** Re-Format plain text after remove HTML tag **/
	protected String reformatText(String str) {
		// Remove HTML tag
		str = this.removeHTML(str);
		
		// Remove extra space
		str = this.removeExtraSpace(str);	

		// Upper case letter after period
		StringBuilder temp = new StringBuilder(str.length());
		
		// The first character after period is capitalize
        boolean capitalize = true;
        int flag = 0;

        // Go through all the characters in the sentence.
        for(int i = 0; i < str.length(); i++) {
            // Get current char
            char c = str.charAt(i);

            // If it's period then set next one to capital
            if(c == '.') {
                capitalize = true;
                flag = 0;
            }
            // Uppercase character after period
            else if(capitalize && Character.isAlphabetic(c) && flag <= 2) {
                // Turn it to uppercase
                c = Character.toUpperCase(c);
                // Don't capitalize next characters
                capitalize = false;
                flag = 0;
            } else {
            	flag++;
            }
            // Accumulate in result
            temp.append(c);
        }
        str = temp.toString();
        
        // Add a spacing after punctuation
        str = str.replaceAll("[,.!?;:]", "$0 ").replaceAll("\\s+", " ");
        
        // Remove spacing before punctuation (. , : ?)
        str = str.replace(" .", ".");
        str = str.replace(" ,", ",");
        str = str.replace(" :", ":");
        return str.replace(" ?", "?");
	}
}
