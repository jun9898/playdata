package api.io;

import java.io.BufferedReader;
import java.io.FileReader;

public class Grade {

	public static void main(String args[]) throws Exception{ 
		
		Grade grade = new Grade();
		
		String fileName = "score.txt";
		grade.printGrade(fileName);
		
	}
		
	public void printGrade(String fileName) throws Exception {
		
		/* 이곳에 프로그램을 완성하십시오. */ 
		
		BufferedReader bf = new BufferedReader(new FileReader(
				"src/api/io/" + fileName));
		
		int count = 0;
		int result = 0;
		while (true) {
			try {
				String[] strArr = bf.readLine().split(",");
				System.out.println( strArr[0] + "의 점수는 " + strArr[1] + "점 입니다.");
				count += Integer.parseInt(strArr[1]);
				result += 1;
			} catch (Exception e) {
				bf.close();
				break;
			}
		}
		System.out.println("모두의 총점은 "+ count + "점 입니다.");
		System.out.println("모두의 평균은 "+ (count/result) + "점 입니다.");
		bf.close();
	} 
	
}