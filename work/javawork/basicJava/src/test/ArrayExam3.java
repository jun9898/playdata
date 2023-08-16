package test;

import oop.basic.MyMethodDemo;

public class ArrayExam3 {
	public static void main(String[] args) {
		int[] ia = new int[]{3,7,1,8,10,2,15,2,10};
		int[] ib = new int[]{1,2,3,4,5};

		MyMethodDemo arrTest = new MyMethodDemo();

		System.out.println("( 배열 ia )");
		arrTest.calcArr(ia);


		System.out.println("( 배열 ib )");
		arrTest.calcArr(ib);
	}
}
