package api.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class InputStreamReaderTest {
	public static void main(String[] args) {
		InputStream myIn = System.in;
		InputStreamReader reader = new InputStreamReader(myIn);
		PrintStream myOut = System.out;

		myOut.println("안녕");
		while (true) {
			int data;
			try {
				data = reader.read();
				if (data==13) {
					break;
				}
				System.out.print((char)data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
