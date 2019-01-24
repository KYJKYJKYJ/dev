package java1008_stream;

import java.io.IOException;
import java.io.InputStream;

//스트림?
//대상(콘솔창..etc)에 연결해서 내용을 읽거나 쓰려면 write라는 클래스, read 클래스 필요하다. 이것들이 스트림 클래스라고 한다.
//이런 입출력 스트림은 java.io에서 제공

public class Java159_stream {

	public static void main(String[] args) {
		System.out.println("데이터 입력");
		
		//콘솔창 목적지에 InputStream으로 연결함
		InputStream is = System.in;
		
		//InputStream은 1바이트 씩 처리
		//read()는 기본적으로 1바이트씩 읽어서 유니코드로 환산함.
		try {
			int line = is.read();
			System.out.println((char)line); // ab 입력하면 1바이트씩 읽기 때문에 결과값은 a
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//end main()

}
