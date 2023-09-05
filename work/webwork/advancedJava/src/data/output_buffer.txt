package api.io;

import java.io.FileWriter;

// 파일의 문자단위로 출력하기
// 파일 쓰기는 파일이 없으면 파일을 생성해서 데이터를 쓴다.
// => 파일 출력은 기본이 덮어쓰기
// 
public class FileWriterTest {
	public static void main(String[] args) throws Exception {
		// 1. 파일 열기
		FileWriter fw = new FileWriter("src/data/output.txt", true);
		// 2. 파일 액세스 (파일에 데이터 쓰기)
		fw.write(97);
		fw.write("\n안녕 자바 \n");
		fw.write("test \n");
		// 3. 파일 닫기
		fw.close();

		
	}

}
