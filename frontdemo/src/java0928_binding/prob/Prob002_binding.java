package java0928_binding.prob;
/*
 * [출력결과]
 * 이름          급여      정규보너스    특별보너스
 * =============================================
 * kim		 1200000	 150000	   	  156000
 * lee		 1750000	 100000		  262500
 * park		 2500000	 150000		  325000
 * hong		 2350000	 100000		  352500
 */

//직군별 보너스를 다르게 지급
 class Employee{
	String name;
	int salary;
	
	public Employee() {
		super();
	}
	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	//정규보너스
	 public int getBonus(){
		 return 0;
	 }     
	
	@Override
	public String toString() {
		return name +"\t" +salary;
	}
}
//--------------------------------------------------------------------------------
class Engineer extends Employee{
	public Engineer() {
		super();
	}

	public Engineer(String name, int salary) {
		super(name, salary);
	}

	@Override
	public int getBonus() {
		return 150000;
	}

	@Override
	public String toString() {
		return super.toString()+"\t"+getBonus();
	}
}
//--------------------------------------------------------------------------------
class Developer extends Employee{
	public Developer() {
		super();
	}

	public Developer(String name, int salary) {
		super(name, salary);
	}

	@Override
	public int getBonus() {
		return 100000;
	}

	@Override
	public String toString() {
		return super.toString()+"\t"+getBonus();
	}
}
//--------------------------------------------------------------------------------
public class Prob002_binding {
	public static void main(String[] args) {
		Employee[] em=new Employee[]{new Engineer("kim",1200000),
									 new Developer("lee",1750000),
									 new Engineer("park",2500000),
									 new Developer("hong",2350000)};
		
/* Engineer는 급여의 13%,  Devloper는 15%를 특별보너스로 지급하는 프로그램을 구현하세요.*/
	
		System.out.println("이름          급여      정규보너스    특별보너스");
		System.out.println("=============================================");
		for(int i = 0; i < em.length; i++) {
			System.out.printf("%s", em[i].toString());
			if(em[i] instanceof Engineer) {
				System.out.printf(" %.0f\n", em[i].salary*0.13);	
			} else {
				System.out.printf(" %.0f\n", em[i].salary*0.15);
			}
			
		}
		
		
		//////////////////////////////////////
		
	}
}














