package java0919_class;
/*
김병조/외과/39
이상만/내과/50
박상기/피부과/20
오상수/내과/25
윤달수/피부과/30
*/

/*
 * [출력결과]
 * 박상기  피부과  20
 * 윤달수  피부과  30
 */
class Doctor{		
	 String name; //의사명
	 String medical; //진료과목
	 int patient; //대기환자수
	
	public Doctor(String name, String medical, int patient) {		
		this.name = name;
		this.medical = medical;
		this.patient = patient;
	}

  public void prn(){
	   System.out.printf("%s %s %d\n", name, medical, patient);
  }
 
}//end Doctor

public class Java075_class {

	public static void main(String[] args) {
		 Doctor[] dt=new Doctor[5];
		   //여기를 구현하세요//////////
		  dt[0] = new Doctor("김병조", "외과", 39);
		  dt[1] = new Doctor("이상민", "내과", 50);
		  dt[2] = new Doctor("박상기", "피부과", 20);
		  dt[3] = new Doctor("오상수", "내과", 25);
		  dt[4] = new Doctor("윤달수", "피부과", 30);
		   //////////////////////
		   search(dt,"피부과");
		}//end main()

		public static void search(Doctor[] dt,  String medical) {
	       //여기를 구현하세요/////////////
        	for(int i = 0; i < dt.length; i++) {
        		if(dt[i].medical == "피부과") {
        			dt[i].prn();
        		}
        	}
		   /////////////////////////
	    }
}//end class