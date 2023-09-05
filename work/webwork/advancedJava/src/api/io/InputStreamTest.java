package api.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

// byte 단위 입력을 위한 클래스의 상위 클래스인 InputStream
// 키보드로 입력한 문자를 읽어서 리턴
public class InputStreamTest {
	public static void main(String[] args) {
		InputStream myIn = System.in;
		PrintStream myOut = System.out;

		myOut.println("안녕");
		try {
			while (true) {
				int data = myIn.read();
				if (data == 13) {
					break;
				}
				// read 메소드는 byte 타입으로 읽어들인다
				myOut.print((char) data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
