package java1008_stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Java161_stream {

	public static void main(String[] args) {
		System.out.println("데이터 입력 : ");
		
		//바이트 스트림
		InputStream is = System.in;
		
		//바이트 스트림과 문자스트림 연결
		InputStreamReader ir = new InputStreamReader(is);
		
		//문자 스트림
		BufferedReader br = new BufferedReader(ir);

		/*try {
			br.read();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		try {
			//readLine() : 한 라인을 읽어와서 String 타입으로 리턴
			String line = br.readLine();
			System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close(); // 스트림 연결 종료
				ir.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
