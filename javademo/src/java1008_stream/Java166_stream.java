package java1008_stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Java166_stream {

	public static void main(String[] args) {
		File file = new File("sample.txt");
		FileReader fr = null;
		BufferedReader br = null;
		int data;
		
		try {
			fr = new FileReader(file);
			while((data=fr.read()) != -1) { // 파일의 끝일때 read는 -1을 리턴
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n" + "================================================");
		
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String line = "";
				while((line = br.readLine()) != null) { // 파일의 끝일때 readLine은 null을 리턴 (read가 readline보다 처리속도가 빠름)
					System.out.println(line); // 줄바꿈 하는 건 안읽어와서 println 사용
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		System.out.println("=====================================================");
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}// end main()

}// end class
