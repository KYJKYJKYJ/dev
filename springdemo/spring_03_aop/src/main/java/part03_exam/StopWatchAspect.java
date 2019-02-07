package part03_exam;

import org.aspectj.lang.ProceedingJoinPoint;

public class StopWatchAspect {

	public void process(ProceedingJoinPoint point) {
		long start = System.currentTimeMillis();
		
		try {
			point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		String time = point.getSignature().getName() + "_메서드 실행시간 : "+(end-start);
		
		System.out.println(time);
	}	//end process()
	
}	//end class
