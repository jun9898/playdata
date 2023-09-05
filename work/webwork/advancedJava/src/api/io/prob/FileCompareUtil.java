package api.io.prob;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileCompareUtil {
	public static void main(String[] args) throws Exception {
		String fstFile = "src/api/io/prob/fstFile1.txt";
		String srdFile = "src/api/io/prob/scdFile1.txt";
		FileCompareUtil f = new FileCompareUtil();
		ArrayList<String> answers = f.compareFile(fstFile, srdFile);
		for (String answer : answers) {
			System.out.println(answer);
		}

		
	}

	public ArrayList<String> compareFile(String fstFileName, String scdFileName) throws Exception {
    // implements compareFile method.
		ArrayList<String> result = new ArrayList<>();
		BufferedReader bf = new BufferedReader(new FileReader(fstFileName));
		BufferedReader bf2 = new BufferedReader(new FileReader(scdFileName));
		while(true) {
			String bfResult = bf.readLine();
			String bf2Result = bf2.readLine();
			if (bfResult == null && bf2Result == null) {
				break;
			}
			if (bfResult.equals(bf2Result)) {
				continue;
			} else {
				result.add(bf2Result);
			}
		}
		return result ;


		
	}
}
