package api.lang;

public class SystemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		String version = System.getProperty("java.version");
		String vendor = System.getProperty("java.vendor");

		System.out.println(osName);
		System.out.println(userName);
		System.out.println(userHome);
		System.out.println(version);
		System.out.println(vendor);

		// 프로그램의 실행시간 - 1970/1/1 기준
		long start = System.currentTimeMillis();
		for (int i = 1; 1 < 10; i++) {
			System.out.println("java");
		}
		long end = System.currentTimeMillis();
		System.out.println(start);
		System.out.println(end);
		System.out.println("실행기간: " + (end - start));
		System.out.println("---------------------------------");
		// JVM이 인식하는 현재 시간을 nanoSec로 변환
		start = System.nanoTime();
		for (int i = 1; 1 < 10; i++) {
			System.out.println("java");
		}
		end = System.nanoTime();
		System.out.println(start);
		System.out.println(end);
		System.out.println("실행기간: " + (end - start));
	}

}
