package assignment;

public class Prob2 {
	public static void main(String args[]) {
		
		Prob2 prob2 = new Prob2();
		
		System.out.println( prob2.leftPad("SBS", 6, '#') );
		System.out.println( prob2.leftPad("SBS", 5, '$') ); 
		System.out.println( prob2.leftPad("SBS", 2, '&') ); 
		 
	}
	public String leftPad(String str, int size, char padChar) {
		String result = "";
		if (str.length() < 6) {
			for (int i = 0; i < size-str.length(); i++) {
				result += padChar;
			}
			result += str;
		}
		return result;

		
		
	}
	
}

