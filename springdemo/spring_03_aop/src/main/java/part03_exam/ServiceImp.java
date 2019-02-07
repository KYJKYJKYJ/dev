package part03_exam;

//Service인터페이스 상속
public class ServiceImp implements Service{

	public ServiceImp() {
		
	}	//end ServiceImp

	@Override
	public void prn() {
		int sum = 0;
		for(int i = 0; i<100000000; i++)
			sum+=i;
		System.out.println("sum : " + sum);
		
	}	//end prn()
	
}	//end class
