package api.util;

import java.util.Vector;

//78,99,100,95,100점을 Vector에 저장하고 저장된 점수의 총점과 평균 구해서 출력
//
public class VectorExam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> scores=new Vector<Integer>();

		scores.add(78);
		scores.add(99);
		scores.add(100);
		scores.add(95);
		scores.add(100);
		
		int sum=0;
		
		int size=scores.size();
		for(int i = 0; i<size;i++) {
			sum+=scores.get(i);
		}
		System.out.println("totalScore: "+sum);
		System.out.println("average: "+(sum/scores.size()));
	}

}
