package part01_xml;

import org.aspectj.lang.ProceedingJoinPoint;

//공통로직한 구현해놓은 클래스-공통관점
public class AspectCommon {

	public AspectCommon() {
		
	}	//end AspectCommon()
	
	public void comm1() {
		System.out.println("before");
	}	//end comm1()
	
	public void comm2() {
		System.out.println("after");
	}	//end comm2()
	
	public void comm3(String name) {
		System.out.println("comm3 : " + name);
	}	//end comm3()
	
	public void comm4(Exception ex) {
		
		if(ex!=null) {
			System.out.println(ex.toString());
		}	
	}	//end comm4()
	
	/*
	 * 핵심로직을 구현해 놓은 빈(클래스) : Target
	 * Target에 구현된 메소드 : JoinPoint
	 * JoinPoint에 실행해야될 위치 : Pointcut
	 */
	public void comm5(ProceedingJoinPoint point) {
		System.out.println("comm5 start");
		try {
			point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("comm5 end");
	}	//end comm5()
}	//end class
