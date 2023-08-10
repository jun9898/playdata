package statement;

public class MultiForExam3_GuGu_Break {
	public static void main(String[] args) {
		for (int i = 2; i <= 9; i++) {
			if (i == 5) {
				break;
			}
			for (int j = 1; j <= 9; j++) {
				System.out.print(i + " * " + j + " = " + (i*j)+ "\t");
			}System.out.println();
		}
	}
}
