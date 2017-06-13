package phase01;

import java.util.ArrayList;
import java.util.Arrays;

public class RichText extends PlainText {
	
	// Constructor with parameter
	public RichText(String value) {
		super(value);
	}
	
	// Constructor default
	public RichText() {
		super();
	}
	
	/************************** METHOD **************************/
	// Break lines after re-format text
	public String[] breakLines(String str) {
		// Call method reformat text from super class
        str = super.reformatText(str);
        
        // Split string by period
        String[] arr = str.split("(?<=[.])");
        
        // Reformat text for each line
        for(int i=0; i<arr.length; i++){
        	arr[i] = super.reformatText(arr[i]);
        }
        
        // Remove the extra lines
        ArrayList<String> result = new ArrayList<>();
		for(String s:arr) {
        	if(!s.equals("")) {
				result.add(s);
		    }
		}
		// Convert from ArrayList to String Array
        return result.toArray(new String[result.size()]);
	}
	
	// Sort after break lines
	public String[] sortText(String str) {
		String[] result = this.breakLines(str);
		Arrays.sort(result);
		return result;
	}
	
	// Add line number for each line after sort text
	public String[] addLine(String str) {
		String[] result = this.sortText(str);
		for(int i=0; i<result.length; i++) {
			result[i] = i+1 + ". " + result[i]; 
		}
		return result;
	}

	// Advance format text after re-format text
	public String[] advanceFormatText(String str) {
		str = super.reformatText(str);
		char[] arrChar = str.toCharArray();
		boolean flag = false; // Text doesn't have any letter in the alphabet
		for (char c:arrChar){
			if((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
				flag = true; // Text has at least one letter in the alphabet
			}
		}
		
		if(flag == true) {
			String[] result = {"", ""};
			result[0] = str.toUpperCase();
			result[1] = str.toLowerCase();
			return result;
		} else {
			String[] result = {str};
			return result;
		}	
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
