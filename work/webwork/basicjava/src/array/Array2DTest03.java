package array;

// 가변배열 - 다차원 배열은 배열의 요소가 참조하는 배열의 사이즈를 다르게 생성할 수 있다.
public class Array2DTest03 {
	public static void main(String[] args) {
		
//		char[][] myarr = new char[5][];
//		myarr[0] = new char[1];
//		myarr[1] = new char[2];
//		myarr[2] = new char[3];
//		myarr[3] = new char[4];
//		myarr[4] = new char[5];

		char[][] myarr = {
				{'*'},
				{'*','*'},
				{'*','*','*'},
				{'*','*','*','*'},
				{'*','*','*','*','*'},
		};
		
		// 값을 할당
		
		for (int row = 0; row < myarr.length; row++) {
			for(int i = 0; i < myarr[row].length; i++) {
				myarr[row][i] = '*';
			}
		}
		
		// 배열에서 값을 꺼내서 할당
		for (int row = 0; row < myarr.length; row++) {
			for(int i = 0; i<myarr[row].length; i++) {
				System.out.print(myarr[row][i]);
			}
			System.out.println();
		}
		
	}

}
