package java1011_stream;

import java.io.File;
import java.io.IOException;

public class Java171_stream {

	public static void main(String[] args) {
		File file = new File("src/java1011_stream/prob.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("파일 생성");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("program end");
	}// end main()

}// end Java171_stream
