package java1011_stream.prob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * [문제]
 *  jumsu.txt 파일로부터 학생의 점수를 읽어들여 총점과 평균을 jumsu.txt 파일 끝에 덧붙여 출력하는 프로그램을 작성하시오.
    단, 평균점수는 소수점 첫 번째 자리까지만 남기고 나머지는 잘라낸다.(truncate) 
    
    [프로그램 실행결과]
    태연:65
	수영:97
	제시카:100
	티파니:86
	써니:88
	총점:436
	평균:87.2
 */
public class Prob02_stream {
	public static void main(String[] args) {
		// 프로그램을 구현하시오.
		int sum = 0;
		double avg = 0;	
		int count = 0;
		
		File files = new File(".\\src\\java1011_stream\\prob\\jumsu.txt");
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(files);
			br = new BufferedReader(fr);
		
			String line;
			while((line = br.readLine()) != null) {
				String[] score = line.split(":");
				sum += Integer.parseInt(score[1]);
				count++;
				
			}
			avg = sum / (double) count;
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("수정 완료");
		}
	
		try {
			//true : append, false : update
			fw = new FileWriter(files, true);
			
			fw.write("\r\n총점 : " + sum + "\r\n");
			fw.write("평균 : " + avg + "\r\n");	
		
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//end main()
}//end class








