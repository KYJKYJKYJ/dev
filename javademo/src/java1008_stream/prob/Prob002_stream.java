package java1008_stream.prob;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;



/*
 * [문제]score.txt 파일의 점수 정보를 읽어 들여서 각 학생의 점수 총합을 
 *       콘솔창에 출력하는 입출력 프로그램을 main() 메서드에 구현하시오.
 * 
 * [프로그램 실행결과]
 * kim의 점수 통합 :146
 * hong의 점수 통합 :243
 * park의 점수 통합 :240
 */
public class Prob002_stream {
	
	public static void main(String[] args) {
	     //각 학생의 총점을 출력하는 프로그램을 구현하시오.
		File file=new File("./src/java1008_stream/prob/score.txt");
		
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				StringTokenizer st = new StringTokenizer(sc.nextLine(), ":/");
				System.out.print(st.nextToken() + "의 점수 통합 : ");
				
				int sum = 0;
				int[] lec = new int[st.countTokens()];
				for(int i = 0; i < lec.length; i++) {
					lec[i] = Integer.parseInt(st.nextToken());
					sum += lec[i];
				}				
				System.out.println(sum);	
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		} finally {
			sc.close();
		}
		
	}//end main()

}//end class











