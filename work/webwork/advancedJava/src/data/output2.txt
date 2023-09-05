package api.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 파일에서 데이터 읽기(byte단위로 읽기)
public class FileReaderTest {
	public static void main(String[] args) {
		FileReader fis = null;
		try {
			// 파일결로를 주지 않고 파일명만 입력하는 경우 기본위치에서 찾는다.
			// 기본위치 => 프로젝트 폴더
			// 1. 파일을 오픈 - OS와 통신해서 읽을 파일을 open
			// fis = new FileReader("src/data/test.txt");
			// fis = new FileReader("C:\\JBJ\\playdata\\work\\webwork\\advancedJava\\src\\data\\test.txt");
			fis = new FileReader("src/data/test.txt");
			// 2. 파일을 액세스
			while (true) {
				int data = fis.read();
				if (data == -1) {
					break;
				}
				System.out.print((char) data);
			}
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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
