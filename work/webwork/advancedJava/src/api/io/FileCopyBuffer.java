package api.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopyBuffer {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("src/api/io/FileWriterTest.java"));
		FileWriter fw = new FileWriter("src/data/output_buffer.txt");
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
