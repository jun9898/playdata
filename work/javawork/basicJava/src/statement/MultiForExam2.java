package statement;

public class MultiForExam2 {
	public static void main(String[] args) {

		int result = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				result += 1;
				System.out.print(result+"\t");
			}
			System.out.println();
		}
	}
}
