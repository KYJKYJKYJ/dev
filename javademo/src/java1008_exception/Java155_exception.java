package java1008_exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Java155_exception {

	public static void main(String[] args) {
		File file = new File("sample.txt");
		FileReader fr = null;
		
		//fr = new FileReader(file); // 예외가 발생하는 메소드에서 예외처리를 해줘야 하는데 생성자로 그냥 떠넘김 (main 메소드로) 그래서 오류 발생.
		//자동생성 할 수 있다 ( 컴파일 단계에서 발생하기 때문에 )
		try {
			fr = new FileReader(file);
		} catch(FileNotFoundException exc) {
			System.out.println(exc.toString());
		} finally {
			//fr.close(); // 위와 마찬가지
			try {
				fr.close(); // 파일이 없는데 닫으라하니 파일 못찾았으면 Nullpointer 예외처리 필요
			} catch(IOException exc) {
				System.out.println(exc.toString());
			} catch(NullPointerException exc) {
				System.out.println(exc.toString());
			}
		}

	}

}
