package statement;

public class WhileExam_Hap {
	public static void main(String[] args) {
		int result = 0;
		int result2 = 0;
		int result3 = 0;
		int i = 1;
		while (true){
			result += i;
			if (i%2 == 0) {
				result2 += i;
			} else {
				result3 += i;
			}
			if (i == 100) {
				break;
			}
			i += 1;
		}
		System.out.println("총합 : " + result);
		System.out.println("짝수합 : " + result2);
		System.out.println("홀수합 : " + result3);
	}

}
