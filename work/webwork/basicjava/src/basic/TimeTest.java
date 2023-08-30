package basic;

public class TimeTest {
	public static void main(String[] args) {

		int time = 8800;
		
		int hour = time / 3600;
		int min = (time % 3600) / 60;
		int sec = time % 3600 % 60;
		
		// 사용자가 직접 정의하는 것들은 식별자 라고 명함 ex) 변수
		System.out.println(hour + "시간 " + min + "분 " + sec + "초");

	}
}