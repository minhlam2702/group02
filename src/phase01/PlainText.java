package phase01;

import java.util.ArrayList;

public class PlainText {

	/************************** Attribute ************************/
	private int numberOfWords; // Total words
	private int numberOfCharacters; // Total characters
	
	// Constructor with parameter
	protected PlainText(String value) {
		this.numberOfWords = this.countWords(value);
		this.numberOfCharacters = this.countCharacters(value);
	}
	
	// Constructor default
	protected PlainText() {
		this.numberOfWords = 0;
		this.numberOfCharacters = 0;
	}
	
	/************************** METHOD ****************************/
	/** Count words from plain text **/
	protected int countWords(String str) {
		try {
			if(!str.equals(null) && !str.equals("")) {
				// Remove extra space
				str = this.removeExtraSpace(str);
				// If text is not equal ""
				if(!str.equals("")) {
					numberOfWords = 1;
					numberOfWords+= str.length() - str.replaceAll(" ", "").length();
				} else {
					numberOfWords = 0;
				}
			} else {
				numberOfWords = 0;
			}
			return numberOfWords;
		} catch (Exception e) {
			return 0;
		}
	}
	
	/** Count characters from plain text **/
	protected int countCharacters(String str) {
		try {
			str = str.replace("\r\n", "");
			numberOfCharacters = str.length();
			return numberOfCharacters;
		} catch (Exception e) {
			return 0;
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
	
	/** Format for array text **/
	protected String[] reformatText(String[] str) {
		for(int i=0; i<str.length; i++) {
			str[i] = this.reformatText(str[i]);
		}
		return str;
	}
	
	/** Format text after remove HTML tag **/
	protected String reformatText(String str) {
		// Remove HTML tag
		str = this.removeHTML(str);
		
		// Remove extra space
		str = this.removeExtraSpace(str);
		
		// Return if string is empty
		if(str.equals("")) {
			return str;
		}	
		
		// Upper case the first letter in string
		str = str.substring(0, 1).toUpperCase() + str.substring(1);
		
		// Add a spacing after punctuation
        str = str.replaceAll("[,.!?;:]", "$0 ").replaceAll("\\s+", " ");
		
		// Upper case letter after period
		StringBuilder temp = new StringBuilder(str.length());

		// The first character after period is capitalize
        boolean capitalize = false;
        int flag = 0;

        // Go through all the characters in the sentence.
        for(int i = 0; i < str.length(); i++) {
            // Get current char
            char c = str.charAt(i);

            // If it's period then set next one to capital
            if(c == '.' || c == '!' || c == '?') {
                capitalize = true;
                flag = 0;
            }
            // Uppercase character after period
            else if(capitalize && flag == 1) {
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
        
        // Remove spacing before punctuation (. , : ? ! ;)
        str = str.replace(" .", ".");
        str = str.replace(" ,", ",");
        str = str.replace(" :", ":");
        str = str.replace(" ;", ";");
        str = str.replace(" !", "!");
        return str.replace(" ?", "?");
	}
	// Split text by \r\n (new line) when user input text with enter
	protected String[] splitStringByNewLine(String str) {
		String[] arr = str.split("(\\r\n)");
		return arr;
		/*
		ArrayList<String> arrList = new ArrayList<String>();
		for(String s:arr) {
			if(!s.equals("\n") && !s.equals("\r")) {
				arrList.add(s);
			}
		}
		return arrList.toArray(new String[arrList.size()]); 
		*/
	}
	
	// Remove null lines for sort and add line functions
	protected String[] removeNullLines(String[] str) {
		ArrayList<String> arrList = new ArrayList<String>();
		for(String s:str) {
			if(!s.equals("\r\n") && !s.equals("")) {
				arrList.add(s);
			}
		}
		return arrList.toArray(new String[arrList.size()]);
	}
}
