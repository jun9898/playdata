package assignment;

public class Test1 {
	public static void main(String[] args) {
		String str = "everyday we have is one more than we deserve";
		
		String result = "";
		for (char i : str.toCharArray()) {
			if (i == ' ') {
				result += i;
				continue;
			}
			if (i+3 <= 122) {
				result += (char) (i+3);
			} else {
				result += (char) (i-12);
			}
		}
		System.out.println(result);
	}

}
