package Array;

public class Array2DExam02 {
	public static void main(String[] args) {
		
		int[][] myArr = new int[2][3];
		
		myArr[0][0] = 90;
		myArr[0][1] = 89;
		myArr[0][2] = 100;
		
		myArr[1][0] = 98;
		myArr[1][1] = 89;
		myArr[1][2] = 97;
		
		for (int[] arr : myArr) {
			int result = 0;
			for (int num : arr) {
				System.out.print(num + "\t");
				result += num;
			}
			System.out.println("합계 : " + result + "\t" + "평균 : " + result/arr.length);
		}
		
	}

}
