package Array; 

public class ArrayTest03 {
	public static void main(String[] args) {
		int[] myarr = new int[5];
		
		myarr[0] = 20;
		myarr[4] = 100;
		
		System.out.println(myarr.length);
		
		for (int i = 0; i < myarr.length; i++) {
			System.out.println(myarr[i]);
		}

		for (int i = myarr.length-1; i >= 0; i--) {
			System.out.println(myarr[i]);
		}
	}
}