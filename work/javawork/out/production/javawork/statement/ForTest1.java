package statement;

public class ForTest1 {
	public static void main(String[] args) {

		System.out.println("시작");

		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "회 반복중");
		}

		System.out.println("=============================");

		for (int i = 10; i >= 1; i--) {
			System.out.println(i + "회 반복중");
		}
		
		System.out.println("=============================");

	}
}