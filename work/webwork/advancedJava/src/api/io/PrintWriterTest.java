package api.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintWriterTest {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("src/api/io/FileWriterTest.java"));
		PrintWriter fw = new PrintWriter("src/data/output4.txt");
		while(true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}
			System.out.println(str);
			fw.write(str+"\n");
		}
		br.close();
		fw.close();
	}
}
