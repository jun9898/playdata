package api.io.prob;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob2 {
	public static void main(String[] args) throws Exception {
		Prob2 p2 = new Prob2();
		p2.printScore("src/api/io/prob/data2.txt");
	}

	public void printScore(String fileName) throws Exception {

		BufferedReader bf = new BufferedReader(new FileReader(fileName));

		String[] strArr = bf.readLine().split("/");
		for (String str : strArr) {
			System.out.print(str + "\t");
		} 
		System.out.println("총점");

		while (true) {
			try {
				int result = 0;
				String[] strArr2 = bf.readLine().split("/");
				for (String str : strArr2) {
					System.out.print(str + "\t");
					try {
						result += Integer.parseInt(str);
					} catch (Exception e) {
						// TODO: handle exception
						continue;
					}
				}
				System.out.println(result);

			} catch (Exception e) {
				bf.close();
				break;
			}
		}
		bf.close();

	}

}
