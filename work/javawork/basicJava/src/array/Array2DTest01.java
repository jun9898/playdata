package array;

public class Array2DTest01 {
	public static void main(String[] args) {
		int myArr[][] = new int[3][2];

		myArr[0][0] = 100;
		myArr[1][0] = 100;
		myArr[2][0] = 100;
		
		System.out.println("배열의 길이 = " + myArr.length);
		System.out.println("배열이 참조하는 배열의 길이 = " + myArr[0].length);
		System.out.println("배열이 참조하는 배열의 길이 = " + myArr[1].length);
		System.out.println("배열이 참조하는 배열의 길이 = " + myArr[2].length);
		
		for(int row = 0; row <3; row++) {
			for (int i = 0; i<2; i++) {
				System.out.print(myArr[row][i] + "\t");
			}
			System.out.println();
		}
	}

}
