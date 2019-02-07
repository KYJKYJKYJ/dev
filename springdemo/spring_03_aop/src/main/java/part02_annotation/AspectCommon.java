package part02_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//공통 로직만 구현해놓은 클래스-공통관점
@Aspect
public class AspectCommon {
   public AspectCommon() {
      
   }
   @Before("execution(* part02_annotation.ServiceImp.prn1(..))")
   public void comm1() {
      System.out.println("before");
   }
   @After("execution(* part02_annotation.ServiceImp.prn2(..))")
   public void comm2() {
      System.out.println("after");
   }
   //value써도 되고 pointcut도 된다.
   @AfterReturning(value="execution(* part02_annotation.ServiceImp.prn3(..))",returning="name")
   public void comm3(String name) {
      System.out.println("comm3: "+name);
   }
   @AfterThrowing(value="execution(* part02_annotation.ServiceImp.prn4(..))",throwing="ex")
   public void comm4(Exception ex) {
      if(ex!=null)
         System.out.println(ex.toString());
   }
   
   /*
       핵심로직을 구현해 놓은 빈(클래스) : Target
       Target에 구현된 메소드 : JoinPoint
       JoinPoint에 실행해야될 위치 : Pointcut
   */

   @Around("execution(* part02_annotation.ServiceImp.prn5(..))")
   public void comm5(ProceedingJoinPoint point) {
      System.out.println("comm5 start");
      try {
         point.proceed();
      } catch (Throwable e) {
         e.printStackTrace();
      }
      System.out.println("comm5 end");
   }
}// end class