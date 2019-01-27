package java1008_stream;

import java.io.File; // 파일에 대한 정보를 볼수 있는 클래스, 크기, 이름 같은 정보를 읽는 메소드들이 들어 있다.
import java.io.FileWriter;
import java.io.IOException;

public class Java165_stream {

	public static void main(String[] args) {
		File file = new File("sample.txt");
		System.out.println(file.exists());
		System.out.println(file.isFile());
		System.out.println(file.length());
		System.out.println(file.canRead());
		
		FileWriter fw = null;
		try {
			//true : append, false : update
			//기본 (false)
			fw = new FileWriter(file);
			fw.write("java\r\n"); // 내부 buffer에 저장 //\r\n해야 줄 바뀜
			fw.write("jsp\r\n");
			fw.flush(); // (지정한 파일에 buffer 내용 기록하고..) 버퍼에 있는 내용 지워짐
			fw.write("spring\r\n");
			//fw.close();
			fw.write("oracle"); //IOException의 Stream close 예외처리 발생
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
