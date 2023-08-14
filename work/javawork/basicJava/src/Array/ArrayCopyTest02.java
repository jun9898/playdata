package Array;

public class ArrayCopyTest02 {
	public static void main(String[] args) {

		int[] firstArr = new int[5];

		for (int i = 0; i < firstArr.length; i++) {
			firstArr[i] = 10+i;
		}

		for (int i = 0; i < firstArr.length; i++) {
			System.out.print(firstArr[i]+ "\t");
		}

		System.out.println();

		// arraycopy 메소드를 이용해서 작업
		
		// 1. 배열의 사이즈를 변경하기 위해서 새로운 배열을 만들어야 한다.
		int[] secondArr = new int[firstArr.length * 3];

		// 2. 기존 배열의 요소를 새로운 배열에 copy하도록 지원되는 System 클래스의 arraycopy 메소드를 활용
		System.arraycopy(firstArr, 0, secondArr, 0, firstArr.length);
		//				---------  -- ---------  -  ---------------> copy할 요소의 갯수
		// 			  카피할 원본 배열  ^	  ^      타겟 배열의 시작위치
		// 						   |	  |_ 타겟 배열
		// 						시작 위치
		
		
		for (int i = 0; i < secondArr.length; i++) {
			System.out.print(secondArr[i]+ "\t");
		}
		System.out.println();

	}

}