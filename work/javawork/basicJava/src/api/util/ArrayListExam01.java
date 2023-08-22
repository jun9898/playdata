package api.util;
//1부터 50까지 랜덤수를 6개 발생시켜서 ArrayList에 저장하고 출력형식대로 출력

import java.util.ArrayList;
import java.util.Random;

//출력형식은 다음과 같다.
//e.g. 랜덤수: 5,7,9,13,40
//5(홀수), 7(홀수), 9(홀수), 13(홀수),40(짝수)
public class ArrayListExam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> arrList = new ArrayList<Integer>();
		Random randNum = new Random();

		for (int i = 1; i <= 6; i++) {
			arrList.add(randNum.nextInt(50) + 1);
		}
		for (int data : arrList) {
			if(data%2==0) {
				System.out.print(data+"(짝수), ");
			}else {
				System.out.print(data+"(홀수), ");
			}
		}
		int j=arrList.size();
		for (int i = 0; i < j-1; i++) {
			int tempNum = arrList.get(i);
			if (tempNum % 2 == 0) {
				System.out.print(tempNum + "(짝수), ");
			}else{
				System.out.print(tempNum + "(홀수), ");
			}
		}
		int tempNum=arrList.get((arrList.size()-1));
		if (tempNum % 2 == 0) {
			System.out.print(tempNum + "(짝수)");
		}else{
			System.out.print(tempNum + "(홀수)");
		}
		
	}

}
