package phase01;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

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
	// Break lines array string
	public String[] breakLines(String[] str) {
		ArrayList<String> arr = new ArrayList<String>();
		String[] tem;
		for(int i=0; i<str.length; i++) {
			tem = breakLines(str[i]);
			for(String s:tem) {
				arr.add(s);
			}
		}
		return arr.toArray(new String[arr.size()]);
	}
	
	// Break lines after re-format text
	public String[] breakLines(String str) {
		// Call method reformat text from super class
        str = super.reformatText(str);
        
        // Convert again the String by character to prevent the case "\n" to "\\n" when converting from SWT text to String 
        String text = ""; 
        int j = 0;
        while (j < str.length()){
        	if(str.length()>0){
        		//Replace "\n." to "."
	        	if (str.charAt(j)==92 && str.charAt(j+1)==78 || str.charAt(j)==92 && str.charAt(j+1)==110){
	        		if (str.charAt(j+2)==46){
	        			text += ".";
		        		str = str.substring(j+3, str.length());
	        		}
	        		else{
	        			text += "\n";
		        		str = str.substring(j+2, str.length());
	        		}
	        	}
	        	else {
	        		if (str.charAt(j)==46 && str.charAt(j+1)==46) {
	        			text += "";
	        			str = str.substring(j+2, str.length());
	        		}
		        	else text += str.charAt(j);
		        	str = str.substring(j+1, str.length());;
	        	}
        	}
        	else text += str.substring(str.length());
        	if (str.length()==2){
        		if (str.charAt(j)==92 && str.charAt(j+1)==78 || str.charAt(j)==92 && str.charAt(j+1)==110)
        		break;
        	}
        }
        
        // Replace String by break line and period
        text = text.replaceAll("\\s\n", ".").replaceAll("\\s\\.{2,}", ".").replaceAll("\\.{2,}", ".");        
        String[] arr = text.split("(?<=[\\.])");
        
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
	
	// Sort after break lines
	public String[] sortText(String[] str) {
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
	
	// Add line number for each line after sort text
	public String[] addLine(String[] str) {
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
	
	// Advance format text after re-format text
	public String[] advanceFormatText(String[] str) {
		str = super.reformatText(str);
		
		ArrayList<String> result = new ArrayList<String>();
		boolean flag = false; // Text doesn't have any letter in the alphabet
		
		for(int i=0; i<str.length; i++) {
			char[] arrChar = str[i].toCharArray();
			
			for (char c:arrChar){
				if((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
					flag = true; // Text has at least one letter in the alphabet
				}
			}
			if(flag == true) {
				result.add(str[i].toUpperCase());
				result.add(str[i].toLowerCase());
			} else {
				result.add(str[i]);
				flag = false;
			}
		}
		return result.toArray(new String[result.size()]);
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
