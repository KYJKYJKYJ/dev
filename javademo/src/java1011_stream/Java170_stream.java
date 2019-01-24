package java1011_stream;

import java.io.File;

/*
 * javademo의 폴더와 파일 리스트를 출력
 */

public class Java170_stream {

	public static void main(String[] args) {
		File file = new File(".");

		System.out.println(file.getAbsolutePath()); // C:\study\workspace\javademo\. // return String
		System.out.println(file.getAbsoluteFile()); // C:\study\workspace\javademo\. // return File

		File[] fileList = file.listFiles();
		for (File f : fileList) {
			System.out.println(f.getName());
		}

	}// end main()

}// end Java170_stream
