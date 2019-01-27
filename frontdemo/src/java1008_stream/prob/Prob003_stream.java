package java1008_stream.prob;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*[문제]
 * data.txt 파일에는 PRODUCT 테이블의 컬럼 이름들이 저장되어있다. 
 * 이 컬럼 이름들을 Java 의 변수명으로 변환하여 콘솔창에 출력하는
 *  makeVariable() 메소드를 구현하시오. 
 * Java 의 변수명은 camel case 가 적용된 형태로 변환해야 한다
 * 
 * [실행결과]
 * prodNo
 * prodName
 * price
 * amount
 * maker
 * regDate
 */

public class Prob003_stream {
	public static void main(String[] args) {
		String fileName = ".\\src\\java1008_stream\\prob\\data.txt";
		makeVariable(fileName);
	}// end main()

	private static void makeVariable(String fileName) {
		// 구현하세요.
		File file = new File(fileName);
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				/*String str = sc.nextLine().toLowerCase();
				char[] strarray = str.toCharArray();				
				for(int i = 0; i < strarray.length; i++) {
					if(strarray[i] == '_') {
						strarray[i+1] -= 32;
					}
				}
				
				for(int i = 0; i < strarray.length; i++) {
					if(strarray[i] != '_') {
						System.out.print(strarray[i]);
					}
				}
				System.out.println();*/
				
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}

	}// end makeVariable()
}// end class
