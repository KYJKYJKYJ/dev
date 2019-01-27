package java1008_stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Java162_stream {

	public static void main(String[] args) {
		System.out.println("데이터 입력 : ");
		
		//바이트 스트림
		InputStream is = System.in;
		
		//바이트 스트림과 문자스트림 연결
		InputStreamReader ir = new InputStreamReader(is);
		
		//문자 스트림
		BufferedReader br = new BufferedReader(ir);

		int x, y;
		try {
			System.out.print("x: ");
			x = Integer.parseInt(br.readLine());
			
			System.out.print("y: ");
			y = Integer.parseInt(br.readLine());
			
			System.out.printf("%d + %d = %d\n", x, y, x+y);
		} catch(NumberFormatException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//end main()

}//end class
