package java1102_jdbc;

import java.util.List;
import java.util.Scanner;

public class Java240_Jdbc {
		/*
		 * 콘솔창에서 입력한 이름이 first_name컬럼에 포함되어 있으면
		 * 대소문자 구분없이 해당되는 레코드를 검색한다.
		 * 이름을 입력하세요? alex
			103 Alexander 9000 1990-01-03
			115 Alexander 3100 1995-05-18
			185 Alexis 4100 1997-02-20
		 */
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("이름을 입력하세요?");
			String word = sc.nextLine();

			EmpDAO dao = EmpDAO.getInstance( );
			List<EmpDTO> aList = dao.searchMethod(word);
			for (EmpDTO dto : aList) {
				System.out.printf("%d %s %d %s\n", 
						dto.getEmployee_id(),
						dto.getFirst_name(), 
						dto.getSalary(),
						dto.getHire_date());
			}

		}//end main( )

}//end class


