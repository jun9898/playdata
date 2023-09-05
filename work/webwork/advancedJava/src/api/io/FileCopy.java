package api.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		FileReader fis = null;
		FileWriter fw = null;
		int count = 0;
		try {
			fis = new FileReader("src/api/io/FileReaderTest.java");
			fw = new FileWriter("src/data/output3.txt");
			// 2. 파일을 액세스
			long start = System.nanoTime();
			while (true) {
				int data = fis.read();
				if (data == -1) {
					break;
				}
				fw.write(data);
				System.out.print((char)data);
				count++;
			}
			long end = System.nanoTime();
			System.out.println("실행횟수 : "+count);
			System.out.println("실행시간 : "+(end - start));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 3. 파일 닫기
			try {
				if (fis != null) {
					fis.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
