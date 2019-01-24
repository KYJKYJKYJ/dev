package java1011_stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Java168_stream {

	public static void main(String[] args) {
		File file = new File("src/java1011_stream/song.txt");
		RandomAccessFile raf = null;
		String stn = new String("\r\nMaron 5 - Daylight, Sunday Moring\r\n");
		try {
			raf = new RandomAccessFile(file, "rw");
			// song.txt파일의 총 길이를 리턴한다.
			long size = raf.length();
			raf.seek(size);

			// 파일에 문자열 추가
			raf.writeBytes(stn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end main()

}// end Java168_stream
