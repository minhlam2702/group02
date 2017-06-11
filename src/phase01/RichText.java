package phase01;

public class RichText extends PlainText{
	
	/************************** Attribute ************************/
	// Constructor with parameter
	public RichText(String value) {
		super(value);
	}
	
	// Constructor default
	public RichText() {
		super();
	}
	
	/************************** METHOD **************************/
	// Break lines text after re-format
	public String[] breakLines(String str) {
        str = this.reformatText(str);
        String[] arr = str.split("(?<=[.])");
        for(int i=0; i<arr.length; i++){
        	arr[i] = this.reformatText(arr[i]);
        }
        return arr;
	}
	
	// Sort text after break lines
	public String sortText(String str) {
		return null;
	}
	
	// Add line number for each line after sort text
	public String addLine(String str) {
		return null;
	}

	// Advance format text after re-format text
	public String[] advanceFormatText(String str) {
		str = super.reformatText(str);
		char[] arrChar = str.toCharArray();
		String[] result = {"", ""};
		for (char c:arrChar){
			if(c >= 65 && c <= 90){
				result[0] += c;
				result[1] += (char)(c += 32);
			}
			else if (c >= 97 && c <= 122){
				result[1] += c;
				result[0] += (char)(c -= 32); 
			}
			else{
				result[0] += c;
				result[1] += c;
			}
		}
		return result;
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
