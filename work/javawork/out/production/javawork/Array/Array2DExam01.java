package array;

public class Array2DExam01 {
	public static void main(String[] args) {
		char[][] strArr = new char[5][5];
		
		int charNum = 65;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i-j == 0) {
					strArr[i][j] = '*';
					charNum += 1;
				}else {
					strArr[i][j] = (char)charNum;
					charNum += 1;
				}
			}
		}
		
		for (char[] chars : strArr) {
			for (char cha : chars) {
				System.out.print(cha);
			}
			System.out.println();
		}
	}

}
