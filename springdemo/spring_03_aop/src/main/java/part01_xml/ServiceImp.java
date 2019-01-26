package part01_xml;

//핵심로직만 구현해 놓은 클래스 - 핵심관점
public class ServiceImp implements Service {
   public ServiceImp() {

   }
   
   //여러메소드의 공통된 로직이 있으면 별도로 빼서 작업을 함, 중복을 최소화하기 위해서
   public void comm() {
      System.out.println("before");
   }
   
   @Override
   public void prn1() {
      //comm(); //하지만 결국 호출을 하는 것도 중복 -> 핵심 로직을 구현하는 클래스 말고 별도로 뺌
      //System.out.println("before");
      System.out.println("prn");
   }

   @Override
   public void prn1(int x) {
      //comm();
      //System.out.println("before");
      System.out.println("x: "+x);
   }

   @Override
   public void prn1(int a, int b) {
      
   }

   @Override
   public void prn2() {
      
   }

   @Override
   public String prn3() {
      return null;
   }

   @Override
   public void prn4() {
      
   }

   @Override
   public void prn5() {
      
   }

}