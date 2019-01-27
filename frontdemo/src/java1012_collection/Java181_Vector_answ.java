package java1012_collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
/* [프로그램 출력결과]
kim    56  78   12  146
hong   46  100  97  243
park   96  56   88  240
*/
public class Java181_Vector_answ {

	public static void main(String[] args) {		
		String sn = "./src/java1012_collection/score.txt";
		Vector<Sawon> vt = lines(sn);
		prnDisplay(vt);
	}//end main()

	private static Vector<Sawon> lines(String strName) {
		// strName 매개변수의 값을 이용해서 Vector에 데이터를 저장한후
		// 리턴하는 프로그램을 구현하시오.
		Vector<Sawon> vt=new Vector<Sawon>();
		File file=new File(strName);
		Scanner sc=null;
		try {
			 sc=new Scanner(file);
			 while(sc.hasNextLine()) {
				//kim:56/78/12
				//hong:46/100/97
				//park:96/56/88
			   String stn=sc.nextLine();
			   String[] data=stn.split("[:/]");
			   Sawon sn=new Sawon(data[0],
					   Integer.parseInt(data[1]),
					   Integer.parseInt(data[2]),
					   Integer.parseInt(data[3]));
			   vt.add(sn);
			 
			 }
		} catch (FileNotFoundException e) {                          
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
		return vt;

	}//end lines()
	
	private static void prnDisplay(Vector<Sawon> vt) {
		// vt에 저장된 객체들을 출력결과와 같이 프로그램을 구현하시오.
		for(Sawon sn : vt) {
			System.out.println(sn.toString());
		}
	
	}//end prnDisplay()
	
	
}//end class
