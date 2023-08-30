package statement;


public class MultiIfExamStarWhile {
	public static void main(String[] args) {
		
		int a = 0;
		boolean flag = true;

		while (true) {
			if (flag == true) {
				for (int i = 2; i < 10; i++) {
					for (int j = 0; j < i; j++) {
						System.out.print("*");
					}
					System.out.println();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
		                e.printStackTrace();
		            }
				} flag = false;
			} else {
				for (int i = 10; i > 0; i--) {
					for (int j = 0; j < i; j++) {
						System.out.print("*");
					}
					System.out.println();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
		                e.printStackTrace();
		            }
				} flag = true;
			} 
		}
	}
}
