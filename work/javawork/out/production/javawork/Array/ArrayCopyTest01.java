package array;

public class ArrayCopyTest01 {
	public static void main(String[] args) {
		int[] firstArr = new int[5];

		for (int i = 0; i < firstArr.length; i++) {
			firstArr[i] = 10+i;
		}

		for (int i = 0; i < firstArr.length; i++) {
			System.out.print(firstArr[i]+ "\t");
		}
		System.out.println();

		// 1. 배열의 사이즈를 변경하기 위해서 새로운 배열을 만들어야 한다.
		int[] secondArr = new int[firstArr.length * 3];

		// 1. 기존 배열의 요소를 새로운 배열에 copy.
		for (int i = 0; i < firstArr.length; i++) {
			secondArr[i] = firstArr[i];
		}
		for (int i = 0; i < secondArr.length; i++) {
			System.out.print(secondArr[i]+ "\t");
		}
		System.out.println();

	}

}
