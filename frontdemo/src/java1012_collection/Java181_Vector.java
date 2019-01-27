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
public class Java181_Vector {

	public static void main(String[] args) {		
		String sn = "./src/java1012_collection/score.txt";
		Vector<Sawon> vt = lines(sn);
		prnDisplay(vt);
	}//end main()

	private static Vector<Sawon> lines(String strName) {
		// strName 매개변수의 값을 이용해서 Vector에 데이터를 저장한후
		// 리턴하는 프로그램을 구현하시오.
		File file = new File(strName);
		Scanner sc = null;
		Vector<Sawon> sawon_v = new Vector<Sawon>();
		
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String[] str = sc.nextLine().split("[:/]");
				Sawon s = new Sawon(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]));
				sawon_v.add(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
			sawon_v.trimToSize();
		}
		
		return sawon_v;
	}//end lines()
	
	private static void prnDisplay(Vector<Sawon> vt) {
		// vt에 저장된 객체들을 출력결과와 같이 프로그램을 구현하시오.
		for(Sawon sawon : vt) {
			System.out.println(sawon.toString());
		}
		
		/*for(int i = 0; i < vt.size(); i++) {
			System.out.println(vt.get(i));
		}*/
	}//end prnDisplay()
	
	
}//end class
