package array;

public class Array2DTest02 {
	public static void main(String[] args) {
		
		int[][] myArr = {{90,89,100},{98,89,97}};
		
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
