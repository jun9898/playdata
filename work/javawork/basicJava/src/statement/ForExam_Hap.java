package statement;

public class ForExam_Hap {
	public static void main(String[] args) {
		int result = 0;
		int result2 = 0;
		int result3 = 0;
		for (int i = 1; i <= 100; i++) {
			result += i;
			if (i%2 == 0) {
				result2 += i;
			} else {
				result3 += i;
			}
		}
		System.out.println("총합 : " + result);
		System.out.println("짝수합 : " + result2);
		System.out.println("홀수합 : " + result3);
	}

}
