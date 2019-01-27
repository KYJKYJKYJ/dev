package java1008_stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Java163_stream {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Scanner는 목적지에서 값을 읽을때만 사용
		//입력 스트림의 값을 처리할 때 사용가능
		
		int x, y;
		
		System.out.print("x: ");
		x = sc.nextInt();
			
		System.out.print("y: ");
		y = sc.nextInt();
			
		System.out.printf("%d + %d = %d\n", x, y, x+y);
	
		sc.close();
	}//end main()

}//end class
