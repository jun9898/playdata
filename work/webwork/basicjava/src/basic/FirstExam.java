package basic;

public class FirstExam {
	public static void main(String[] args) {

		// 국어, 영어, 수학점수를 임의로 정의하고 총점과 평균을 출력하지
		// 출력 형식
		// 총점:
		// 평군:
		
		int 국어 = 90;
		int 영어 = 50;
		int 수학 = 100;
		
		int 총점 = 국어 + 영어 + 수학;
		int 평균 = 총점/3;
		
		System.out.println("총점 : " + 총점);
		System.out.println("평균 : " + 평균);
	}
}