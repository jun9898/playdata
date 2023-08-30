package oop.basic;
//구구단출력하기
public class MultiForExam3_GuGu_ {
	
	public void printGuGu() {
		for(int dan=2;dan<=9;dan++) {
			for(int i=1;i<=9;i++) {
				System.out.print(dan + "*"+i+"="+(dan*i)+"\t");
			}
			System.out.println();
		}
	}
}
