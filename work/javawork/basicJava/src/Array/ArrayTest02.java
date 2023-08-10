package Array;

import java.util.Random;

public class ArrayTest02 {
	public static void main(String[] args) {

		int myarr[] = new int[3];
		double myarr2[] = new double[3];
		boolean myarr3[] = new boolean[3];
		String myarr4[] = new String[3];
		Random myarr5[] = new Random[3];

		System.out.println(myarr[0]); //0
		System.out.println(myarr2[0]); // 0.0
		System.out.println(myarr3[0]); // false
		System.out.println(myarr4[0]); // null
		System.out.println(myarr5[0]); // null
		
		myarr[0] = 100;
		myarr[1] = 200;
		myarr[2] = 300;
		myarr[3] = 400;
		
		for (int num : myarr) {
			System.out.println(num);
		}
	}
}
