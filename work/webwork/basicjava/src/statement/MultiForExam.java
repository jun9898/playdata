package statement;

public class MultiForExam {
	public static void main(String[] args) {
		for(int i = 1; i <=5; i++) {
			for(int j = 1; j <=5; j++) {
				if (i == 3 && j == 3) {
					System.out.print("너\t");
				} else {
					System.out.print("2\t");
				}
			}System.out.println();
		}
	}
}
