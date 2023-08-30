package basic;

public class OprTest01 {
	public static void main(String[] args) {

		int x;
		int y;

		x = 5;
		y = x++;
		System.out.println("X = " + x + " y = " + y);

		x = 5;
		y = ++x;
		System.out.println("X = " + x + " y = " + y);

		x = 5;
		y = x--;
		System.out.println("X = " + x + " y = " + y);

		x = 5;
		y = --x;
		System.out.println("X = " + x + " y = " + y);

	}

}
