package java1011_stream;

import java.io.File;

public class Java169_stream {

	public static void main(String[] args) {
		File file = new File("src/java1011_stream/temp");
		if (!file.isDirectory()) {
			// mkdir() : 디렉토리 생성 [ make directory ]
			file.mkdir();

		}
		// 디렉토리가 존재하는지 판단.
		System.out.println(file.isDirectory());

		// 디렉토리에 파일이 존재하는지 판단.
		System.out.println(file.isFile());

		// 파일이 존재하는지 판단.
		file = new File("src/java1011_stream/song.txt");
		System.out.println(file.exists());

		file = new File("src/java1011_stream");
		String[] list = file.list();
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println("/////////////////////////");

		File[] listFile = file.listFiles();
		for (File f : listFile) {
			// if(f.isFile())
			System.out.println(f.getName());
		}

		System.out.println("/////////////////////////");
		file = new File("src/java1011_stream/source.txt");
		if (file.exists()) {
			// 파일 삭제
			file.delete();
			System.out.println(file.getName() + "파일 삭제");

		} else {
			System.out.println(file.getName() + "파일 없음");
		}

	}// end main()

}// end Java169_stream
